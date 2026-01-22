package com.mihucha.back.controller;

import com.mihucha.back.dto.UsuarioDto;
import com.mihucha.back.mapper.UsuarioMapper;
import com.mihucha.back.model.Usuario;
import com.mihucha.back.repository.UsuarioRepository;
import com.mihucha.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> newUser (@RequestBody UsuarioDto usuarioDto){
        if (!usuarioService.existUser(usuarioDto.getEmail())){
            Usuario usuario = usuarioMapper.getUsuarioByDto(usuarioDto);
            usuarioService.saveUsuario(usuario);

            Usuario createdUser = usuarioService.getUserByEmail(usuarioDto.getEmail());
            return ResponseEntity.ok(usuarioMapper.toDto(createdUser));
        }
        else{
            throw new RuntimeException("Ya hay un usuario con el correo electrónico " +usuarioDto.getEmail());
        }
    }
}
