package com.ld.mod05atividade.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        double priceWithDiscount = product.getPriceWithDiscount(0.05);
        assertEquals(95, priceWithDiscount);
    }

    @Test
    public void shouldCalculateTotalPriceWithMaxDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        double priceWithMaxDiscount = product.getPriceWithDiscount(0.15);
        assertEquals(90, priceWithMaxDiscount);
    }
}
