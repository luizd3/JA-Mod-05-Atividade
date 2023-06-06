package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.OrderItem;
import com.ld.mod05atividade.models.OrderRequestItem;
import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

    public OrderItem orderItemBuilder(OrderRequestItem orderRequestItem) {
        Product product = productRepository.findAProductGivenItsId(orderRequestItem.getId());
        return new OrderItem(orderRequestItem, product);
    }

}