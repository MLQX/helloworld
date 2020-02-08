package com.example.demo.pojo;


import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend extends CloneSupport<Friend> implements Serializable {
    private static final long serialVersionUID = -2350623691428014225L;
    private long id;
    private String name;
    private SimpleObj simpleObj;
}



