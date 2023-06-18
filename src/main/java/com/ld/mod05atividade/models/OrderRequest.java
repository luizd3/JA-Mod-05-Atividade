package com.ld.mod05atividade.models;

import com.ld.mod05atividade.adapters.requests.OrderItemRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRequest {

    private List<OrderItemRequest> orderRequestList;

    public OrderRequest(List<OrderItemRequest> orderRequestList) {
        this.orderRequestList = orderRequestList;
    }

    public OrderRequest() {}

    public List<OrderItemRequest> getOrderRequestList() {
        return orderRequestList;
    }
}
