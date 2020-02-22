package com.example.demo.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStep implements Serializable {
    private static final long serialVersionUID = -1401042844110610270L;
    private long orderId;
    private String desc;
}
