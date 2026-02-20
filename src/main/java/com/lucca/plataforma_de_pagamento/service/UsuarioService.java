package com.lucca.plataforma_de_pagamento.service;

import com.lucca.plataforma_de_pagamento.entities.Carteira;
import com.lucca.plataforma_de_pagamento.entities.Usuario;
import com.lucca.plataforma_de_pagamento.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        Carteira carteira = new Carteira();
        carteira.setSaldo(BigDecimal.valueOf(500.00));
        carteira.setUsuario(usuario);
        usuario.setCarteira(carteira);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> atualizarPorId(Usuario usuario, Long id){
        return usuarioRepository.findById(id).map(existingUsuario -> {
            existingUsuario.setTipo(usuario.getTipo());
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setCpf_cnpj(usuario.getCpf_cnpj());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setSenha(usuario.getSenha());

            return usuarioRepository.save(existingUsuario);

        });

    }

    public void deletarPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
