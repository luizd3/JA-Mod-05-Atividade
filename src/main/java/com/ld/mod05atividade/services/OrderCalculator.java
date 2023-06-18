package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.Order;
import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderCalculator {

    public Double calculateOrder(final Order order) {
        return order.getItems().stream()
                .mapToDouble(OrderItemResponse::totalPrice)
                .sum();
    }
}
