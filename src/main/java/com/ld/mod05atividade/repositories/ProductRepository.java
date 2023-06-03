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
        // Produtos pré-cadastrados
        addProductToList(new Product(UUID.fromString("0b5f5444-e9a9-4868-946f-aecccb16ebdf"), "Air Fryer", 450.00, 0.15, 18));
        addProductToList(new Product(UUID.fromString("5f676f7a-8e2c-4c04-935b-3c387a16ab22"), "Liquidificador", 127.90, 0.12, 10));
        addProductToList(new Product(UUID.fromString("680b6aab-b1da-4d99-bacf-a6f93d41a566"), "Sofá", 2489.90, 0.18, 8));
        addProductToList(new Product(UUID.fromString("ff8b8efa-c650-4bef-bef6-ce8199229ce6"), "Guarda-roupas", 1357.99, 0.07, 5));
        addProductToList(new Product(UUID.fromString("7f091242-50a7-4a6d-a7dc-f55aca9077ae"), "Jogo de Pratos", 269.80, 0.05, 15));
    }

    public List<Product> findAll() {
        return productList;
    }

    private void addProductToList(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        productList.add(product);
    }

    public void addProductQuantity(UUID id, Integer quantidade)  {
        Product productFound = findAll().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();

        productFound.setQuantidade(productFound.getQuantidade() + quantidade);
    }
}
