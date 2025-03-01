package com.habits.api.service.impl;

import com.habits.api.domain.model.Habito;
import com.habits.api.domain.model.Usuario;
import com.habits.api.domain.repository.HabitoRepository;
import com.habits.api.domain.repository.UsuarioRepository;
import com.habits.api.service.HabitoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoServiceImpl implements HabitoService {

    private final HabitoRepository habitoRepository;
    private final UsuarioRepository usuarioRepository;

    public HabitoServiceImpl(HabitoRepository habitoRepository, UsuarioRepository usuarioRepository) {
        this.habitoRepository = habitoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Habito> listarPorUsuario(Long usuarioId) {
        return habitoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Habito buscarPorId(Long id) {
        return habitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado."));
    }

    @Override
    public Habito criar(Long usuarioId, Habito habito) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        habito.setUsuario(usuario);
        return habitoRepository.save(habito);
    }

    @Override
    public Habito atualizar(Long id, Habito habito) {
        Habito existente = buscarPorId(id);
        existente.setTitulo(habito.getTitulo());
        existente.setDescricao(habito.getDescricao());
        existente.setFrequencia(habito.getFrequencia());
        return habitoRepository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        Habito existente = buscarPorId(id);
        habitoRepository.delete(existente);
    }
}
