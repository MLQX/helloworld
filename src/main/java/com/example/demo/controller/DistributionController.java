package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 * 分布式锁 demo
 */
@RestController
public class DistributionController {


    @Autowired
    private RedisTemplate redisTemplate;

    private  static final long INTERVAL = 5L; // 5 秒

    private final String lockKey = "lockKey";
    @GetMapping("/reduce_stock")
    public String reduceStock(){
        String uuid = UUID.randomUUID().toString();  //防止线程乱序


        //定时器的作用是设定合适的key过期时间，设定过期时间的原因是防止宕机，锁不能及时释放
        //过期时间设定太小，可能业务代码没执行完，key就过期了
        //过期时间设定太大， 影响业务性能， 于是设定一个定时器，每隔一段时间检查redis中该键是否存在，如还存在，就给他重设过期时间
        //这样，这个过期时间可以设定的小一点
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Object ret = redisTemplate.opsForValue().get(lockKey);
                if (ret != null) {
                    //如果lockKey存在
                    System.out.println("开始续命...");
                    redisTemplate.expire(lockKey, INTERVAL,TimeUnit.SECONDS);
                }else{
                    System.out.println("键已过期");
                }
            }
        },2000L,INTERVAL*1000);  //单位毫秒

        try {


            // 如果
            Boolean lockValue = redisTemplate.opsForValue().setIfAbsent(lockKey, uuid, INTERVAL, TimeUnit.SECONDS);

            if (!lockValue) {
                //未获得锁，返回错误码，让客户端稍后再试
                return "error";
            }


            //取得锁之后，执行逻辑
            {
                //  模拟高延时业务
                try {

                    System.out.println("开始睡眠");
                    Thread.sleep(30000);
                    System.out.println("结束睡眠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {

            if (uuid.equals(redisTemplate.opsForValue().get(lockKey))){
                redisTemplate.delete(lockKey);   //防止发生异常
            }
            timer.cancel();

        }

        return "success";

    }

}
