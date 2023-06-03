package com.ld.mod05atividade.services;

import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProductQuantity(UUID id, Integer quantidade) {
        productRepository.addProductQuantity(id, quantidade);
    }

}
