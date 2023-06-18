package com.ld.mod05atividade.adapters.requests;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderItemRequest {

    private UUID id;
    private int quantidade;
    private double desconto;

    public OrderItemRequest(UUID id, int quantidade, double desconto) {
        this.id = id;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public OrderItemRequest() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
