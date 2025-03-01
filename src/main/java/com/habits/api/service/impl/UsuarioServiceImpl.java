package com.habits.api.service.impl;

import com.habits.api.domain.model.Usuario;
import com.habits.api.domain.repository.UsuarioRepository;
import com.habits.api.service.UsuarioService;
import org.springframework.stereotype.Service;
import com.habits.api.service.exception.NotFoundException;
import com.habits.api.service.exception.BusinessException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }

    @Override
    public Usuario criar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new BusinessException("E-mail já cadastrado.");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario existente = buscarPorId(id);
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        return usuarioRepository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        Usuario existente = buscarPorId(id);
        usuarioRepository.delete(existente);
    }
}
