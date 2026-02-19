package com.lucca.plataforma_de_pagamento.response;

import com.lucca.plataforma_de_pagamento.entities.Carteira;
import com.lucca.plataforma_de_pagamento.enums.TipoDeUsuario;
import lombok.Builder;

@Builder
public record UsuarioResponseDto(Long id,
                                 TipoDeUsuario tipo,
                                 String nome,
                                 String cpf_cnpj,
                                 String email,
                                 String senha,
                                 Carteira carteira


) {
}
