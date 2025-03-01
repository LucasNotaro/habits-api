package com.habits.api.domain.repository;

import com.habits.api.domain.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitoRepository extends JpaRepository<Habito, Long> {

    List<Habito> findByUsuarioId(Long usuarioId);
}
