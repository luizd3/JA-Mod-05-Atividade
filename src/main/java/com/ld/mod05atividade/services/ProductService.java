package com.ld.mod05atividade.services;

import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import com.ld.mod05atividade.adapters.OrderItemAdapter;
import com.ld.mod05atividade.models.*;
import com.ld.mod05atividade.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemAdapter orderItemAdapter;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProductQuantity(UUID id, Integer quantidade) {
        productRepository.addProductQuantity(id, quantidade);
    }

    public double sellProducts(OrderRequest orderRequest) {
        List<OrderItemResponse> orderItemResponseList = orderRequest.getOrderRequestList().stream()
                .map(orderItemRequest -> orderItemAdapter.toOrderItemResponse(orderItemRequest)
                ).toList();
        Order order = new Order(orderItemResponseList);

        double totalOrderPrice = order.getItems().stream()
                .mapToDouble(OrderItemResponse::totalPrice)
                .sum();
        return totalOrderPrice;
    }

    // Regra de negócio: Ao tentar dar um desconto maior do que o permitido para o produto,
    // deve ser considerado o desconto máximo.
    static public double getPriceWithDiscount(Product product, double desconto) {
        if (desconto > product.getDescontoMaximo()) {
            return product.getValor() * (1 - product.getDescontoMaximo());
        }
        return product.getValor() * (1 - desconto);
    }
}
