package com.gruponiche.fitorfat.hu18core.repositorio;

import com.gruponiche.fitorfat.hu18core.modelo.RutinaEjercicioHasEjercicio;
import com.gruponiche.fitorfat.hu18core.modelo.dto.EjercicioDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RutinaEjercicioHasEjercicioRepositorio extends JpaRepository<RutinaEjercicioHasEjercicio, Integer> {

    @Query(nativeQuery = true)
    public List<EjercicioDTO> comenzarRutinaDeEjercicios(@Param("rutina") Integer rutina);
}
