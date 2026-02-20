package com.lucca.plataforma_de_pagamento.mapper;

import com.lucca.plataforma_de_pagamento.entities.Transacao;
import com.lucca.plataforma_de_pagamento.response.TransacaoResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public TransacaoResponseDto toResponse(Transacao transacao){
        return TransacaoResponseDto.builder()
                .id(transacao.getId())
                .valor(transacao.getValor())
                .data(transacao.getData())
                .remetente(transacao.getRemetente())
                .destinatario(transacao.getDestinatario())
                .build();
    }

}
