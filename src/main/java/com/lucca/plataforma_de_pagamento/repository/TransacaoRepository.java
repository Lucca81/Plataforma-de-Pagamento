package com.lucca.plataforma_de_pagamento.repository;

import com.lucca.plataforma_de_pagamento.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
