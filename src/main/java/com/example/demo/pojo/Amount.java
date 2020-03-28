package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Amount {

    private String id;

    private Long money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}