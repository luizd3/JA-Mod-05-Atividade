package com.ld.mod05atividade.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);

        OrderRequestItem orderRequestItem = new OrderRequestItem();
        orderRequestItem.setDesconto(0.05);
        orderRequestItem.setQuantidade(2);

        OrderItem orderItem = new OrderItem(orderRequestItem, product);
        double totalPrice = orderItem.totalPrice();

        assertEquals(190, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceWithMaxDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);

        OrderRequestItem orderRequestItem = new OrderRequestItem();
        orderRequestItem.setDesconto(0.15);
        orderRequestItem.setQuantidade(2);

        OrderItem orderItem = new OrderItem(orderRequestItem, product);
        double totalPrice = orderItem.totalPrice();

        assertEquals(180, totalPrice);
    }
}
