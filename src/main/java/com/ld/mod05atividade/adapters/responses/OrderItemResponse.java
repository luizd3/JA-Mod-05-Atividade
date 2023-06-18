package com.ld.mod05atividade.adapters.responses;

import com.ld.mod05atividade.adapters.requests.OrderItemRequest;
import com.ld.mod05atividade.models.Product;
import com.ld.mod05atividade.services.ProductService;
import org.springframework.stereotype.Component;

@Component
public class OrderItemResponse {

    private OrderItemRequest orderItemRequest;
    private Product product;

    public OrderItemResponse(OrderItemRequest orderItemRequest, Product product) {
        this.orderItemRequest = orderItemRequest;
        this.product = product;
    }

    public OrderItemResponse() {}

    public double totalPrice() {
        int orderQuantity = getOrderQuantityAccordingToStock(orderItemRequest.quantidade());
        double priceWithDiscount = ProductService.getPriceWithDiscount(product, orderItemRequest.desconto());
        return orderQuantity * priceWithDiscount;
    }

    // Regra de negócio: Ao tentar realizar uma venda de uma quantidade maior do que a disponível em estoque,
    // deve ser vendido apenas a quantidade de produtos disponíveis.
    private int getOrderQuantityAccordingToStock(int orderQuantity) {
        if (orderQuantity < product.getQuantidade()) {
            return orderQuantity;
        }
        return product.getQuantidade();
    }

    public OrderItemRequest getOrderRequestItem() {
        return orderItemRequest;
    }

    public void setOrderRequestItem(OrderItemRequest orderItemRequest) {
        this.orderItemRequest = orderItemRequest;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
