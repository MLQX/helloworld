package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.User2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User2 findByUsername(String username);

    void updateLastLoginTimeByUserName(Date lastLoginTime, String username);

    User2 save(User2 user);
}
