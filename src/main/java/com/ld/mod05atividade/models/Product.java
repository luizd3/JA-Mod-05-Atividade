package com.ld.mod05atividade.models;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Product {

    private UUID id;
    private String nome;
    private double valor;
    private double descontoMaximo;
    private int quantidade;

    public Product() {}

    public Product(UUID id, String nome, double valor, double descontoMaximo, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descontoMaximo = descontoMaximo;
        this.quantidade = quantidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
