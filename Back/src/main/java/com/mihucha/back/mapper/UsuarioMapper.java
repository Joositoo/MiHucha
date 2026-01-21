package com.mihucha.back.mapper;

import com.mihucha.back.dto.UsuarioDto;
import com.mihucha.back.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioMapper {

    public Usuario getUsuarioByDto(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword_hash(usuarioDto.getPassword_hash());
        usuario.setFecha_alta(LocalDateTime.now());

        return usuario;
    }

    public UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getFecha_alta());
    }

}
