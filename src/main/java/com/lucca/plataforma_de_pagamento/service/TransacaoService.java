package com.lucca.plataforma_de_pagamento.service;

import com.lucca.plataforma_de_pagamento.entities.Transacao;
import com.lucca.plataforma_de_pagamento.entities.Usuario;
import com.lucca.plataforma_de_pagamento.enums.TipoDeUsuario;
import com.lucca.plataforma_de_pagamento.repository.TransacaoRepository;
import com.lucca.plataforma_de_pagamento.request.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final UsuarioService usuarioService;
    private final TransacaoRepository transacaoRepository;

    public List<Transacao> listarTransferencias() {
        return transacaoRepository.findAll();
    }

    @Transactional
    public Transacao realizarTransferencias(TransacaoRequestDto dados) {
        Usuario remetente = usuarioService.buscarPorId(dados.remetenteId())
                .orElseThrow();
        Usuario destinatario = usuarioService.buscarPorId(dados.destinatarioId())
                .orElseThrow();

        if (remetente.getTipo().equals(TipoDeUsuario.LOJISTA)) {
            throw new RuntimeException("Erro: LOJISTAS não podem transferir");
        }
        if (remetente.getCarteira().getSaldo().compareTo(dados.valor()) < 0) {
            throw new RuntimeException("Erro: Saldo insuficiente");

        }

        BigDecimal valorSubtraido = remetente.getCarteira().getSaldo().subtract(dados.valor());
        remetente.getCarteira().setSaldo(valorSubtraido);

        BigDecimal valorSomado = destinatario.getCarteira().getSaldo().add(dados.valor());
        destinatario.getCarteira().setSaldo(valorSomado);

        Transacao transacaoAtualizada = new Transacao();
        transacaoAtualizada.setValor(dados.valor());
        transacaoAtualizada.setRemetente(remetente);
        transacaoAtualizada.setDestinatario(destinatario);
        transacaoAtualizada.setData(OffsetDateTime.now());




        return transacaoRepository.save(transacaoAtualizada);

    }
}
