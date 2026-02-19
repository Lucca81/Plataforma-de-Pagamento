package com.lucca.plataforma_de_pagamento.controller;

import com.lucca.plataforma_de_pagamento.entities.Usuario;
import com.lucca.plataforma_de_pagamento.mapper.UsuarioMapper;
import com.lucca.plataforma_de_pagamento.request.UsuarioRequestDto;
import com.lucca.plataforma_de_pagamento.response.UsuarioResponseDto;
import com.lucca.plataforma_de_pagamento.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@RequestBody UsuarioRequestDto requestDto) {
        Usuario save = usuarioService.cadastrarUsuario(usuarioMapper.toDomain(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarUsuarios() {
        List<Usuario> lista = usuarioService.listarUsuarios();
        List<UsuarioResponseDto> listaDto = lista.stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizarPorId(@RequestBody UsuarioRequestDto requestDto, @PathVariable Long id) {

        return usuarioService.atualizarPorId(usuarioMapper.toDomain(requestDto), id)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> detarPorId(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }


}
