package com.example.demo.other;


import com.example.demo.pojo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CompleteDataBind {
    public static void main(String[] args) throws IOException {
        String s = "{\"id\": 1,\"name\": \"小明\",\"array\": [\"1\", \"2\"]}";
        ObjectMapper mapper = new ObjectMapper();
        //Json映射为对象
        Student student = mapper.readValue(s, Student.class);
        //对象转化为Json
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        System.out.println(student.toString());
    }
}
