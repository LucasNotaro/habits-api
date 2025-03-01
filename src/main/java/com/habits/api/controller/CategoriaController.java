package com.habits.api.controller;

import com.habits.api.controller.dto.CategoriaDto;
import com.habits.api.domain.model.Categoria;
import com.habits.api.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listar() {
        var categorias = categoriaService.listar();
        var dtos = categorias.stream().map(CategoriaDto::new).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(new CategoriaDto(categoriaService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> criar(@RequestBody CategoriaDto dto) {
        var nova = categoriaService.criar(dto.toModel());
        return ResponseEntity.status(201).body(new CategoriaDto(nova));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaDto dto) {
        var atualizada = categoriaService.atualizar(id, dto.toModel());
        return ResponseEntity.ok(new CategoriaDto(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
