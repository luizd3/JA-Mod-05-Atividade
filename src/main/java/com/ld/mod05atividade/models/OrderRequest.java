package com.ld.mod05atividade.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRequest {

    private List<OrderRequestItem> orderRequestList;

    public OrderRequest(List<OrderRequestItem> orderRequestList) {
        this.orderRequestList = orderRequestList;
    }

    public OrderRequest() {}

    public List<OrderRequestItem> getOrderRequestList() {
        return orderRequestList;
    }
}
