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
        int orderQuantity = getOrderQuantityAccordingToStock(orderRequestItem.getQuantidade());
        double priceWithDiscount = product.getPriceWithDiscount(orderRequestItem.getDesconto());
        return orderQuantity * priceWithDiscount;
    }

    // Regra de negócio: Ao tentar realizar uma venda de uma quantidade maior do que a disponível em estoque,
    // deve ser vendido apenas a quantidade de produtos disponíveis.
    private int getOrderQuantityAccordingToStock(int orderQuantity) {
        if (orderQuantity < product.getQuantidade()) {
            return orderQuantity;
        }
        return product.getQuantidade();
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
