package com.ld.mod05atividade.models;

import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order {
    
    private final List<OrderItemResponse> items;

    public Order(List<OrderItemResponse> items) {
        this.items = items;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

}