package com.habits.api.service.impl;

import com.habits.api.domain.model.Categoria;
import com.habits.api.domain.repository.CategoriaRepository;
import com.habits.api.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
    }

    @Override
    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Long id, Categoria categoria) {
        Categoria existente = buscarPorId(id);
        existente.setNome(categoria.getNome());
        return categoriaRepository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        Categoria existente = buscarPorId(id);
        categoriaRepository.delete(existente);
    }
}
