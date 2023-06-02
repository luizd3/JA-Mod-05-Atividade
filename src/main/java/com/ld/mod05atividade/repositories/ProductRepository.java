package com.ld.mod05atividade.repositories;

import com.ld.mod05atividade.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {

    private final List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
    }

    public List<Product> findAll() {
        return productList;
    }

    public void addProductToList(Product product) {
        product.setId(UUID.randomUUID());
        productList.add(product);
    }
}
