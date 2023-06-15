package com.ld.mod05atividade.controllers;

import com.ld.mod05atividade.models.OrderRequest;
import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addProduct(@PathVariable("id") UUID id,
                                             @PathVariable("quantidade") Integer quantidade) {
        productService.addProductQuantity(id, quantidade);
        final String message = "Estoque de produto adicionado.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellProducts(@RequestBody final OrderRequest orderRequest) {
        double valorTotalFinalDaVenda = productService.sellProducts(orderRequest);
        final String message = "Valor total final da venda: R$ " + valorTotalFinalDaVenda;
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}
