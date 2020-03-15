package com.example.demo.mapper;

import com.example.demo.pojo.Amount;
import org.springframework.stereotype.Component;

@Component
public interface AmountMapper {
    int insert(Amount record);

    int insertSelective(Amount record);
}