package com.ld.mod05atividade.controllers;

import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @PatchMapping("/{id}/{quantidade}")
    public void addProduct(@PathVariable("id") UUID id, @PathVariable("quantidade") Integer quantidade) {
        productService.addProductQuantity(id, quantidade);
    }

}
