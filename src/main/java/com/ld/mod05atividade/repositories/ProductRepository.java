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
        addProductToList(new Product("Air Fryer", 450.00, 0.15, 18));
        addProductToList(new Product("Liquidificador", 127.90, 0.12, 10));
        addProductToList(new Product("Sofá", 2489.90, 0.18, 8));
        addProductToList(new Product("Guarda-roupas", 1357.99, 0.07, 5));
        addProductToList(new Product("Jogo de Pratos", 269.80, 0.05, 15));
    }

    public List<Product> findAll() {
        return productList;
    }

    private void addProductToList(Product product) {
        product.setId(UUID.randomUUID());
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
