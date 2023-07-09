package com.gruponiche.fitorfat.hu18core.repositorio;

import com.gruponiche.fitorfat.hu18core.modelo.RutinaEjercicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RutinaEjercicioRepositorio extends JpaRepository<RutinaEjercicio, Integer>  {
    
    @Query(nativeQuery = true)
    public List<RutinaEjercicio> buscarRutinasDeEjercicios(
            @Param("frase") String frase, 
            @Param("nivel") String nivel, 
            @Param("tipo") String tipo);
}
