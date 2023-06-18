package com.ld.mod05atividade.models;

import com.ld.mod05atividade.adapters.requests.OrderItemRequest;
import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemResponseTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        product.setQuantidade(2);

        OrderItemRequest orderItemRequest = new OrderItemRequest();
        orderItemRequest.setDesconto(0.05);
        orderItemRequest.setQuantidade(2);

        OrderItemResponse orderItemResponse = new OrderItemResponse(orderItemRequest, product);
        double totalPrice = orderItemResponse.totalPrice();

        assertEquals(190, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceWithMaxDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        product.setQuantidade(2);

        OrderItemRequest orderItemRequest = new OrderItemRequest();
        orderItemRequest.setDesconto(0.15);
        orderItemRequest.setQuantidade(2);

        OrderItemResponse orderItemResponse = new OrderItemResponse(orderItemRequest, product);
        double totalPrice = orderItemResponse.totalPrice();

        assertEquals(180, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceWithQuantityInStock() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        product.setQuantidade(5);

        OrderItemRequest orderItemRequest = new OrderItemRequest();
        orderItemRequest.setDesconto(0.00);
        orderItemRequest.setQuantidade(3);

        OrderItemResponse orderItemResponse = new OrderItemResponse(orderItemRequest, product);
        double totalPrice = orderItemResponse.totalPrice();

        assertEquals(300, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceWithQuantityOutOfStock() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        product.setQuantidade(5);

        OrderItemRequest orderItemRequest = new OrderItemRequest();
        orderItemRequest.setDesconto(0.00);
        orderItemRequest.setQuantidade(10);

        OrderItemResponse orderItemResponse = new OrderItemResponse(orderItemRequest, product);
        double totalPrice = orderItemResponse.totalPrice();

        assertEquals(500, totalPrice);
    }
}
