package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.*;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProductQuantity(UUID id, Integer quantidade) {
        productRepository.addProductQuantity(id, quantidade);
    }

    public double sellProducts(OrderRequest orderRequest) {
        List<OrderItem> orderItemList = orderRequest.getOrderRequestList().stream()
                .map(orderRequestItem -> {
                    return orderService.orderItemBuilder(orderRequestItem);
                }
                ).toList();
        Order order = new Order(orderItemList);
        double totalOrderPrice = order.getItems().stream()
                .mapToDouble(OrderItem::totalPrice)
                .sum();
        return totalOrderPrice;
    }
}
