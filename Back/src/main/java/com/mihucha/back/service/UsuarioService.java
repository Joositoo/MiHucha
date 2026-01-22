package com.mihucha.back.service;

import com.mihucha.back.dto.UsuarioDto;
import com.mihucha.back.model.Usuario;
import com.mihucha.back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean existUser(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario getUserByEmail (String email){
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public boolean isRegisteredUser(UsuarioDto usuarioDto) {
        return usuarioRepository.existsByEmailAndPassword(usuarioDto.getEmail(), usuarioDto.getPassword_hash());
    }
}
