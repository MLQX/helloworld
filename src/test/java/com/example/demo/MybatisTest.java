package com.example.demo;

import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;




    @Test
    public void testMybatisLoad(){
        Assert.notNull(userMapper.selectByPrimaryKey(19295828219195L),"GE");
    }
}
