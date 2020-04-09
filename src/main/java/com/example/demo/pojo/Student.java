package com.example.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private int[] array;


    public void thorwExp() {
        int a = 1 / 0;
        throw new RuntimeException("i am 异常");
    }
}



