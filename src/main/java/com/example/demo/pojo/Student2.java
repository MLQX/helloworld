package com.example.demo.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Student2 {

    @JSONField(name = "AGE",ordinal = 3,serialize = false)
    private int age;

    @JSONField(name = "FULL NAME",ordinal=1)
    private String fullName;

    @JSONField(name = "DATE OF BIRTH",ordinal=2,format = "yyyy/MM/dd HH:mm:ss")
    private Date dateOfBirth;

    public Student2(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName= fullName;
        this.dateOfBirth = dateOfBirth;
    }

    // 标准 getters & setters
}



