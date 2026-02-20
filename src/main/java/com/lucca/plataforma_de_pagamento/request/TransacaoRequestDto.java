package com.lucca.plataforma_de_pagamento.request;

import java.math.BigDecimal;

public record TransacaoRequestDto(
        BigDecimal valor,
        Long remetenteId,
        Long destinatarioId
) {
}
