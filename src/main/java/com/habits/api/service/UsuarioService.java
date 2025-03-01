package com.habits.api.service;

import com.habits.api.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario buscarPorId(Long id);

    Usuario criar(Usuario usuario);

    Usuario atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
