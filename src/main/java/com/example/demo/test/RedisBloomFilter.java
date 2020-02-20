package com.example.demo.test;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


/**
 * redis布隆过滤器 (布隆过滤器规则: 如果所有位都重复不代表是重复数据,如果有哪怕一位不重复,则肯定不是重复数据)
 * <p>
 * 新增数据处理后id填充布隆过滤器(得HASH,设置bitmap的位) ->
 * 当新的请求来对比id , 看看是不是能在布隆过滤器中找到重复数据 ->
 * true:判定为重复数据则进缓存找,如果没有,则是系统误判, 此时进入数据库
 * false: 判定为非重复数据则直接进数据库
 */

public class RedisBloomFilter {
    static final int expectedInsertions = 100;//要插入多少数据
    static final double fpp = 0.01;//期望的误判率

    //bit数组长度
    private static long numBits;

    //hash函数数量
    private static int numHashFunctions;

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);
    private static Map<String,Object> map = new HashMap<>();
    static {
        numBits = optimalNumOfBits(expectedInsertions, fpp);
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, numBits);
        //数据模拟0(对象,需要用到序列化知识,篇幅过长,大家自己尝试一下)
        //map.put("10000001", new Goods("10000001","雕牌洗衣粉",6.25,"洗衣粉" ));
        //map.put("10000002", new Goods("10000002","小米空调",3006,"小米空调" ));
        //map.put("10000003", new Goods("10000003","任天堂switch",1776.99,"任天堂switch" ));
        //map.put("10000004", new Goods("10000004","联想笔记本电脑",6799,"联想笔记本电脑" ));

        //数据模拟1(这里只缓存价格)
        map.put("10000001", 6.25);
        map.put("10000002", 3006);
        map.put("10000003", 1776.99);
        map.put("10000004", 6799);
    }

    public static void main(String[] args) {

        //模拟入缓存的数据
        map.forEach((k,v)->{
            jedis.set(k, String.valueOf(v));
            long[] indexs = getIndexs(String.valueOf(k));
            for (long index : indexs) {
                jedis.setbit("codebear:bloom", index, true);
            }

        });

        //模拟用户请求的数据
        String userInput1 = "10000001";
        String userInput2 = "10000005";
        String[] arr = {userInput1, userInput2};
        for (int j = 0; j < arr.length; j++) {
            boolean repeated = true;
            long[] indexs = getIndexs(String.valueOf(arr[j]));
            for (long index : indexs) {
                Boolean isContain = jedis.getbit("codebear:bloom", index);
                if (!isContain) {
                    System.out.println(arr[j] + "肯定没有重复!");
                    repeated = false;
                    //从数据库获取数据
                    String retVal = getByDb(arr[j]);
                    System.out.println("数据库获取到的数据为"+retVal);
                    break;
                }
            }
            if (repeated) {
                System.out.println(arr[j] + "有重复!");
                //尝试从缓存获取
                String retVal = getByCache(arr[j]);
                if (retVal == null) {
                    //从数据库获取
                    retVal = getByDb(arr[j]);
                    System.out.println("数据库获取到的数据为"+retVal);
                    break;

                }
                System.out.println("缓存获取到的数据为"+retVal);

            }
        }

    }


    /**
     * 从缓存获取数据
     */
    public static String getByCache(String key){
        return jedis.get(key);
    }

    /**
     * 从数据库获取数据
     */
    public static String getByDb(String key){
        //从数据库获取数据逻辑没有实现
        return "";
    }

    /**
     * 根据key获取bitmap下标
     */
    private static long[] getIndexs(String key) {
        long hash1 = hash(key);
        long hash2 = hash1 >>> 16;
        long[] result = new long[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            long combinedHash = hash1 + i * hash2;
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            result[i] = combinedHash % numBits;
        }
        return result;
    }

    private static long hash(String key) {
        Charset charset = Charset.forName("UTF-8");
        return Hashing.murmur3_128().hashObject(key, Funnels.stringFunnel(charset)).asLong();
    }

    //计算hash函数个数
    private static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    //计算bit数组长度
    private static long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }
}

//商品类 (lombok插件)
@Data
@AllArgsConstructor
class Goods{
    private String goodsId;
    private String name;
    private double price;
    private String descrption;
}