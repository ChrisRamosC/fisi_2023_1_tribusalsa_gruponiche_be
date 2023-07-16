package com.gruponiche.fitorfat.hu18core.servicio;

import com.gruponiche.fitorfat.hu18core.modelo.RutinaEjercicio;
import com.gruponiche.fitorfat.hu18core.repositorio.RutinaEjercicioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaEjercicioServicio {

    @Autowired
    private RutinaEjercicioRepositorio rep;

    public List<RutinaEjercicio> buscarRutinasDeEjercicios(
            String frase,
            String nivel,
            String tipo) {
        return rep.buscarRutinasDeEjercicios(frase, nivel, tipo);
    }
}
