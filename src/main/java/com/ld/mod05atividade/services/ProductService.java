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

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProductQuantity(UUID id, Integer quantidade) {
        productRepository.addProductQuantity(id, quantidade);
    }

    public double sellProducts(OrderRequest orderRequest) {
        List<OrderItem> orderList = orderRequest.getOrderRequestList().stream()
                .map(OrderItem::new).toList();

        Order order = new Order(orderList);

        double totalOrderPrice = order.getItems().stream()
                .mapToDouble(OrderItem::totalPrice)
                .sum();

        return totalOrderPrice;
    }
}
