package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @program: trunk
 * @description: 服务端响应类
 * @author: lilong
 * @create 2018-07-19 12:36
 **/
public class ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = 4865613148911899760L;
    private int status;
    private String msg;
    private T data;

    public ServerResponse() {

    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 使之不在 json 序列化结果中
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    // success
    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T date) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), date);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T date) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, date);
    }

    // error
    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    // 自定义的异常响应
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
