package com.ld.mod05atividade.models;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderRequestItem {

    private UUID id;
    private int quantidade;
    private double desconto;

    public OrderRequestItem(UUID id, int quantidade, double desconto) {
        this.id = id;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public OrderRequestItem() {}

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
