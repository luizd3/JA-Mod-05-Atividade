package com.ld.mod05atividade.models;

import com.ld.mod05atividade.services.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        double priceWithDiscount = ProductService.getPriceWithDiscount(product,0.05);
        assertEquals(95, priceWithDiscount);
    }

    @Test
    public void shouldCalculateTotalPriceWithMaxDiscount() {
        Product product = new Product();
        product.setValor(100);
        product.setDescontoMaximo(0.10);
        double priceWithMaxDiscount = ProductService.getPriceWithDiscount(product,0.15);
        assertEquals(90, priceWithMaxDiscount);
    }
}
