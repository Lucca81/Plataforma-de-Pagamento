package com.lucca.plataforma_de_pagamento.repository;

import com.lucca.plataforma_de_pagamento.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
