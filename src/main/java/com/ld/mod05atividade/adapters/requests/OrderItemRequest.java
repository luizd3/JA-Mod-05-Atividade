package com.ld.mod05atividade.adapters.requests;

import java.util.UUID;

public record OrderItemRequest (
        UUID id,
        int quantidade,
        double desconto
) {
}
