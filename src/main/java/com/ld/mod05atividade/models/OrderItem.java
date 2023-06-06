package com.ld.mod05atividade.models;

import org.springframework.stereotype.Component;

@Component
public class OrderItem {

    private OrderRequestItem orderRequestItem;
    private Product product;

    public OrderItem(OrderRequestItem orderRequestItem, Product product) {
        this.orderRequestItem = orderRequestItem;
        this.product = product;
    }

    public OrderItem() {}

    public double totalPrice() {
        return product.getPriceWithDiscount(orderRequestItem.getDesconto()) * orderRequestItem.getQuantidade();
    }

    public OrderRequestItem getOrderRequestItem() {
        return orderRequestItem;
    }

    public void setOrderRequestItem(OrderRequestItem orderRequestItem) {
        this.orderRequestItem = orderRequestItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
