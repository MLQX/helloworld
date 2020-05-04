package com.example.demo.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student3{

    @JSONField(name = "GRADE",serialize = true)
    private Integer grade;

    @JSONField(name = "TEL")
    private String tel;

    @JSONField(name = "ADDRESS")
    private String  addr;

    @JSONField(name = "PROVINCE")
    private String  province;

    @JSONField(name = "CITY")
    private String  city;

}



