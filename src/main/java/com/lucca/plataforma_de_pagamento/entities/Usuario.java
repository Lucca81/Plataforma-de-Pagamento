package com.lucca.plataforma_de_pagamento.entities;

import com.lucca.plataforma_de_pagamento.enums.TipoDeUsuario;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipo;
    private String nome;
    @Column(unique = true)
    private String cpf_cnpj;
    private String email;
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Carteira carteira;





}
