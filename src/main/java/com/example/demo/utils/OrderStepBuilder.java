package com.example.demo.utils;

import com.example.demo.other.OrderStep;

import java.util.ArrayList;
import java.util.List;

public class OrderStepBuilder {

    public static List<OrderStep> build(){

        List<OrderStep> orderSteps = new ArrayList<>();

        //构建 订单号为 102L. 305L . 807L 的一系列 订单流程   新建->付款->推送->完成
        OrderStep o1 = new OrderStep(102L, "新建");
        OrderStep o2 = new OrderStep(102L, "付款");
        OrderStep o3 = new OrderStep(102L, "推送");
        OrderStep o4 = new OrderStep(102L, "完成");

        OrderStep o5 = new OrderStep(305L, "新建");
        OrderStep o6 = new OrderStep(305L, "付款");
        OrderStep o7 = new OrderStep(305L, "推送");

        OrderStep o8 = new OrderStep(807L, "新建");
        OrderStep o9 = new OrderStep(807L, "付款");

        orderSteps.add(o1);
        orderSteps.add(o2);
        orderSteps.add(o3);
        orderSteps.add(o4);
        orderSteps.add(o5);
        orderSteps.add(o6);
        orderSteps.add(o7);
        orderSteps.add(o8);
        orderSteps.add(o9);



        return orderSteps ;
    }

}
