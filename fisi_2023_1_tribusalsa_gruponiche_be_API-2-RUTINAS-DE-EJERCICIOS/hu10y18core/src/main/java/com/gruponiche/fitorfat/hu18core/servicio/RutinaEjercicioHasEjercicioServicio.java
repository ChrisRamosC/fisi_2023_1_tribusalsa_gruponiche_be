package com.gruponiche.fitorfat.hu18core.servicio;

import com.gruponiche.fitorfat.hu18core.modelo.dto.EjercicioDTO;
import com.gruponiche.fitorfat.hu18core.repositorio.RutinaEjercicioHasEjercicioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaEjercicioHasEjercicioServicio {
    
    @Autowired
    private RutinaEjercicioHasEjercicioRepositorio reher;
    
    public List<EjercicioDTO> comenzarRutinaDeEjercicios(Integer id) {
        return reher.comenzarRutinaDeEjercicios(id);
    }
}
