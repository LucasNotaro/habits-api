package com.habits.api.service;

import com.habits.api.domain.model.Habito;

import java.util.List;

public interface HabitoService {

    List<Habito> listarPorUsuario(Long usuarioId);

    Habito buscarPorId(Long id);

    Habito criar(Long usuarioId, Habito habito);

    Habito atualizar(Long id, Habito habito);

    void deletar(Long id);
}
