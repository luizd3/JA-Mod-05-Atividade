package com.ld.mod05atividade.services;

import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

}