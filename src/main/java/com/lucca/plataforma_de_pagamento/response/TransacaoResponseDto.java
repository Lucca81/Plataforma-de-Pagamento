package com.lucca.plataforma_de_pagamento.response;

import com.lucca.plataforma_de_pagamento.entities.Usuario;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Builder
public record TransacaoResponseDto(
        Long id,
        BigDecimal valor,
        OffsetDateTime data,
        Usuario remetente,
        Usuario destinatario
) {
}
