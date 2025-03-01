package com.habits.api.controller.dto;

import com.habits.api.domain.model.Usuario;

public record UsuarioDto(Long id, String nome, String email) {

    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        return usuario;
    }
}
