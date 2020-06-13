package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.User2;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/6/12 15:09
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;


    //注册或登录
    @PostMapping("/login")
    @Transactional
    public ServerResponse login(@RequestBody User2 user, HttpServletResponse response){

        String username = user.getUsername();
        String password = user.getPassword();
        // TODO  检验参数的完整性
        User2 tUser = userMapper.findByUsername(username);
        //检验username是否存在
        user.setLastLoginTime(new Date());
        if(tUser!=null){
            //检验密码是否正确
            if(!tUser.getPassword().equals(password)) {
                return ServerResponse.createByError();
            }
            userMapper.updateLastLoginTimeByUserName(user.getLastLoginTime(),username);

        }else {
            try {
                userMapper.save(user);
            } catch (Exception e) {
                return ServerResponse.createByError();
            }
        }
        Map<String, String> retMap = new HashMap<>();
        String token = JwtUtil.generateToken(username, user.getLastLoginTime());
        retMap.put("token",token );
        Cookie cookie = new Cookie("token",token);
        response.addCookie(cookie);
        return ServerResponse.createBySuccess(retMap);
    }


}
