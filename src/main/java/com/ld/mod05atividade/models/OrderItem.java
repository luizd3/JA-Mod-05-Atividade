package com.ld.mod05atividade.models;

import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItem {

    private OrderRequestItem orderRequestItem;
    private Product product;

    @Autowired
    private ProductRepository productRepository;

    public OrderItem(OrderRequestItem orderRequestItem) {
        this.orderRequestItem = orderRequestItem;
        this.product = productRepository.findAll().stream()
                .filter(product1 -> product1.getId().equals(orderRequestItem.getId()))
                .findFirst().get();
    }

    public OrderItem() {}

    public double totalPrice() {
        return product.getPriceWithDiscount(orderRequestItem.getDesconto()) * orderRequestItem.getQuantidade();
    }

    public OrderRequestItem getOrderRequest() {
        return orderRequestItem;
    }

    public void setOrderRequest(OrderRequestItem orderRequestItem) {
        this.orderRequestItem = orderRequestItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
