package com.example.demo.utils;

/**
 * @program: trunk
 * @description: 常见响应代码
 * @author: lilong
 * @create 2018-07-19 12:37
 **/
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"), // 成功
    ERROR(1, "ERROR"), // 异常
    NEED_LOGIN(10, "NEED_LOGIN"), // 需要登录
    NOT_LOGIN(11, "NOT_LOGIN"), // 未登录
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"); // 参数异常

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc(){
        return desc;
    }

}
