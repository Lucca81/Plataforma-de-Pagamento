package com.lucca.plataforma_de_pagamento.mapper;

import com.lucca.plataforma_de_pagamento.entities.Usuario;
import com.lucca.plataforma_de_pagamento.request.UsuarioRequestDto;
import com.lucca.plataforma_de_pagamento.response.UsuarioResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioRequestDto requestDto){
        return Usuario.builder()
                .id(requestDto.id())
                .tipo(requestDto.tipo())
                .nome(requestDto.nome())
                .cpf_cnpj(requestDto.cpf_cnpj())
                .email(requestDto.email())
                .senha(requestDto.senha())
                .carteira(requestDto.carteira())
                .build();
    }

    public UsuarioResponseDto toResponse(Usuario usuario){
        return UsuarioResponseDto.builder()
                .id(usuario.getId())
                .tipo(usuario.getTipo())
                .nome(usuario.getNome())
                .cpf_cnpj(usuario.getCpf_cnpj())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .carteira(usuario.getCarteira())
                .build();
    }
}
