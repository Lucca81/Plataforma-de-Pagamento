package com.lucca.plataforma_de_pagamento.request;

import com.lucca.plataforma_de_pagamento.entities.Carteira;
import com.lucca.plataforma_de_pagamento.enums.TipoDeUsuario;

public record UsuarioRequestDto(Long id,
                                TipoDeUsuario tipo,
                                String nome,
                                String cpf_cnpj,
                                String email,
                                String senha,
                                Carteira carteira






                                ) {
}
