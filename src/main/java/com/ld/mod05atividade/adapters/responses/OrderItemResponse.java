package com.ld.mod05atividade.adapters.responses;

import com.ld.mod05atividade.adapters.requests.OrderItemRequest;
import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.services.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderItemResponse {

    private OrderItemRequest orderItemRequest;
    private Product product;

    public OrderItemResponse(OrderItemRequest orderItemRequest, Product product) {
        this.orderItemRequest = orderItemRequest;
        this.product = product;
    }

    public OrderItemResponse() {}

    public double totalPrice() {
        OrderService orderService = new OrderService();
        return orderService.totalPrice(this);
    }

    public OrderItemRequest getOrderItemRequest() {
        return orderItemRequest;
    }

    public void setOrderItemRequest(OrderItemRequest orderItemRequest) {
        this.orderItemRequest = orderItemRequest;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
