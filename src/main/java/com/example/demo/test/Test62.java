package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/5 22:36
 *
 *
 */
@Slf4j
public class Test62 {


    @Before
    public void before() {

    }

    @Test
    public void test1() {


        String hello = "年后";
        char c = hello.charAt(0);
        log.debug(String.valueOf(c));
    }
}
