package com.mihucha.back.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto {
    private int id;
    private String nombre;
    private String email;
    private String password_hash;
    private LocalDateTime fechaAlta;

    public UsuarioDto(String nombre, String email, String password_hash) {
        this.nombre = nombre;
        this.email = email;
        this.password_hash = password_hash;
    }

    public UsuarioDto(String email, String password_hash) {
        this.email = email;
        this.password_hash = password_hash;
    }

    public UsuarioDto(int id, String nombre, String email, LocalDateTime fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }

    public UsuarioDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
