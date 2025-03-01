package com.habits.api.controller;

import com.habits.api.controller.dto.UsuarioDto;
import com.habits.api.domain.model.Usuario;
import com.habits.api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listar() {
        return ResponseEntity.ok(
                usuarioService.listar()
                        .stream()
                        .map(UsuarioDto::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(new UsuarioDto(usuario));
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> criar(@RequestBody UsuarioDto dto) {
        Usuario novo = usuarioService.criar(dto.toModel());
        return ResponseEntity.status(201).body(new UsuarioDto(novo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        Usuario atualizado = usuarioService.atualizar(id, dto.toModel());
        return ResponseEntity.ok(new UsuarioDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
