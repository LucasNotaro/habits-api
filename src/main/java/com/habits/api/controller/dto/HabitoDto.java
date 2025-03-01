package com.habits.api.controller.dto;

import com.habits.api.domain.model.Habito;
import com.habits.api.domain.model.Frequencia;

public record HabitoDto(
        Long id,
        String titulo,
        String descricao,
        Frequencia frequencia,
        String categoriaNome
) {

    public HabitoDto(Habito habito) {
        this(
                habito.getId(),
                habito.getTitulo(),
                habito.getDescricao(),
                habito.getFrequencia(),
                habito.getCategoria() != null ? habito.getCategoria().getNome() : null
        );
    }

    public Habito toModel() {
        var habito = new Habito();
        habito.setId(this.id);
        habito.setTitulo(this.titulo);
        habito.setDescricao(this.descricao);
        habito.setFrequencia(this.frequencia);
        // não setamos categoria e usuario aqui — isso é feito no serviço
        return habito;
    }
}
