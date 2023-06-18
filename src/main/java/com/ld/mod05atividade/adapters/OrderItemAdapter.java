package com.ld.mod05atividade.adapters;

import com.ld.mod05atividade.adapters.requests.OrderItemRequest;
import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemAdapter {

    @Autowired
    ProductRepository productRepository;

    public OrderItemResponse toOrderItemResponse(OrderItemRequest orderItemRequest) {
        Product product = productRepository.findAProductGivenItsId(orderItemRequest.getId());
        return new OrderItemResponse(orderItemRequest, product);
    }

}
