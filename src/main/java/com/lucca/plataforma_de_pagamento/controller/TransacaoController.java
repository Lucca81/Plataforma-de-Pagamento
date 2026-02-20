package com.lucca.plataforma_de_pagamento.controller;

import com.lucca.plataforma_de_pagamento.entities.Transacao;
import com.lucca.plataforma_de_pagamento.mapper.TransacaoMapper;
import com.lucca.plataforma_de_pagamento.request.TransacaoRequestDto;
import com.lucca.plataforma_de_pagamento.response.TransacaoResponseDto;
import com.lucca.plataforma_de_pagamento.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;
    private final TransacaoMapper transacaoMapper;

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDto>> listarTransacoes(){
       List <Transacao> lista = transacaoService.listarTransferencias();
       List<TransacaoResponseDto> listaDto = lista.stream()
               .map(transacaoMapper::toResponse)
               .collect(Collectors.toList());

       return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDto> transferencias(@RequestBody TransacaoRequestDto dados){
        Transacao save = transacaoService.realizarTransferencias(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoMapper.toResponse(save));

    }
}
