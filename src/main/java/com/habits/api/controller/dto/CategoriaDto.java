package com.habits.api.controller.dto;

import com.habits.api.domain.model.Categoria;

public record CategoriaDto(Long id, String nome) {

    public CategoriaDto(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }

    public Categoria toModel() {
        var categoria = new Categoria();
        categoria.setId(this.id);
        categoria.setNome(this.nome);
        return categoria;
    }
}
