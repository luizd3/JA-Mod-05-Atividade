package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.Order;
import com.ld.mod05atividade.models.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderCalculator {

    public Double calculateOrder(final Order order) {
        return order.getItems().stream()
                .mapToDouble(OrderItem::totalPrice)
                .sum();
    }
}
