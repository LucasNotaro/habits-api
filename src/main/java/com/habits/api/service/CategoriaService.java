package com.habits.api.service;

import com.habits.api.domain.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listar();

    Categoria buscarPorId(Long id);

    Categoria criar(Categoria categoria);

    Categoria atualizar(Long id, Categoria categoria);

    void deletar(Long id);
}
