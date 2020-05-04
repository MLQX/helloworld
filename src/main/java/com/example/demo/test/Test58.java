package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.example.demo.pojo.Student2;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 19:43
 *
 *
 * fastjson工具
 */

@Slf4j
public class Test58 {
    private List<Student2> listOfStudent2s = new ArrayList<Student2>();
    @Before
    public void before(){
        listOfStudent2s.add(new Student2(15, "John Doe", new Date()));
        listOfStudent2s.add(new Student2(20, "Janette Doe", new Date()));
    }
    @Test
    public void test1() {
        String jsonOutput= JSON.toJSONString(listOfStudent2s); //从对象到字符串
        log.debug(jsonOutput);


    }

    /**
     * 新建 json对象,单个用jsonObject,多个的数组的形式的json用jsonArray
     */
    @Test
    public void test2(){
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("AGE", 10);
            jsonObject1.put("FULL NAME", "Doe" + i);
            jsonArray.add(jsonObject1);
        }
        String jsonOutput = jsonArray.toJSONString();
        log.debug(jsonOutput);

    }


    /**
     * 解析json到javabean  反序列化
     */
    @Test
    public void test3(){
        Student2 student2 = new Student2(20,"jassdow",new Date());
        String jsonObject = JSON.toJSONString(student2);
        log.debug(jsonObject);

        Student2 student21 = JSON.parseObject(jsonObject, Student2.class);
        log.debug(student21.getDateOfBirth().toString());
        Date date = student21.getDateOfBirth();
        String d = DateUtil.formatDateTime(date);
        log.debug("当前日期转字符串"+d);  //这里本来不应该损失时间精度的， 但是Bean（Student2)的dateOfBirth字段有format，当他从bean->json时，就只剩日期了

        Assert.assertEquals(student21.getAge(), 20);
        //Assert.assertEquals(student21.getDateOfBirth(), "2020/05/04");

    }



    /**
     * 使用 ContextValueFilter 配置 JSON 转换
     */
    @Test
    public void test4(){
        ContextValueFilter valueFilter = new ContextValueFilter () {
            public Object process(
                    BeanContext context, Object object, String name, Object value) {
                if (name.equals("DATE OF BIRTH")) {
                    return "NOT TO DISCLOSE";
                }
                if (value.equals("John")) {
                    return ((String) value).toUpperCase();
                } else {
                    return null;
                }
            }
        };
        String jsonOutput = JSON.toJSONString(listOfStudent2s, valueFilter);//过滤器


        //对json名统一处理
        NameFilter formatName = new NameFilter() {
            public String process(Object object, String name, Object value) {
                return name.toLowerCase().replace(" ", "_");
            }
        };
        SerializeConfig.getGlobalInstance().addFilter(Student2.class,  formatName);


        //对返回的时间统一做format
        String jsonOutput2 =
                JSON.toJSONStringWithDateFormat(listOfStudent2s, "yyyy-MM-dd");
    }





}
