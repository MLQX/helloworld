package com.example.demo.mapper;

import com.example.demo.pojo.Amount;

public interface AmountMapper {
    int insert(Amount record);

    int insertSelective(Amount record);
}