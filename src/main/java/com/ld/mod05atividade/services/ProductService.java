package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProductToList(Product product) {
        productRepository.addProductToList(product);
    }

    public List<Product> getProductsList() {
        return productRepository.findAll();
    }
}
