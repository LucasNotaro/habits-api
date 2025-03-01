package com.habits.api.controller;

import com.habits.api.controller.dto.HabitoDto;
import com.habits.api.domain.model.Habito;
import com.habits.api.service.HabitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/habitos")
public class HabitoController {

    private final HabitoService habitoService;

    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @GetMapping
    public ResponseEntity<List<HabitoDto>> listar(@PathVariable Long usuarioId) {
        var habitos = habitoService.listarPorUsuario(usuarioId);
        var dtos = habitos.stream().map(HabitoDto::new).toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<HabitoDto> criar(@PathVariable Long usuarioId, @RequestBody HabitoDto dto) {
        var criado = habitoService.criar(usuarioId, dto.toModel());
        return ResponseEntity.status(201).body(new HabitoDto(criado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(new HabitoDto(habitoService.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitoDto> atualizar(@PathVariable Long id, @RequestBody HabitoDto dto) {
        var atualizado = habitoService.atualizar(id, dto.toModel());
        return ResponseEntity.ok(new HabitoDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        habitoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
