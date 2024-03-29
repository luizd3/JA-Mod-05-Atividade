package com.ld.mod05atividade.services;

import com.ld.mod05atividade.adapters.responses.OrderItemResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double totalPrice(OrderItemResponse orderItemResponse) {
        int orderQuantity = getOrderQuantityAccordingToStock(orderItemResponse);
        double priceWithDiscount = ProductService.getPriceWithDiscount(
                orderItemResponse.getProduct(),
                orderItemResponse.getOrderItemRequest().desconto()
        );
        return orderQuantity * priceWithDiscount;
    }

    // Regra de negócio: Ao tentar realizar uma venda de uma quantidade maior do que a disponível em estoque,
    // deve ser vendido apenas a quantidade de produtos disponíveis.
    public static int getOrderQuantityAccordingToStock(OrderItemResponse orderItemResponse) {
        int quantityRequested = orderItemResponse.getOrderItemRequest().quantidade();
        int quantityInStock = orderItemResponse.getProduct().getQuantidade();
        if (quantityRequested < quantityInStock) {
            return quantityRequested;
        }
        return quantityInStock;
    }
}