package com.ld.mod05atividade.models;

import java.util.List;

public class OrderRequest {

    private final List<OrderRequestItem> orderRequestList;

    public OrderRequest(List<OrderRequestItem> orderRequestList) {
        this.orderRequestList = orderRequestList;
    }

    public List<OrderRequestItem> getOrderRequestList() {
        return orderRequestList;
    }
}
