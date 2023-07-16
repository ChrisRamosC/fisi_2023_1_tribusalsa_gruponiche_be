package com.gruponiche.fitorfat.hu18core.controlador;

import com.gruponiche.fitorfat.hu18core.modelo.RutinaEjercicio;
import com.gruponiche.fitorfat.hu18core.modelo.dto.EjercicioDTO;
import com.gruponiche.fitorfat.hu18core.servicio.RutinaEjercicioHasEjercicioServicio;
import com.gruponiche.fitorfat.hu18core.servicio.RutinaEjercicioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ux-rutina-ejercicios/fitorfat/servicio-al-cliente/v1")
public class RutinaEjercicioHasEjercicioControlador {
    
    @Autowired
    private RutinaEjercicioHasEjercicioServicio rehes;

    @GetMapping("/comenzar/{id}")
    public ResponseEntity<List<EjercicioDTO>> comenzarRutinaDeEjercicios(
            @PathVariable("id") Integer id) {
        List<EjercicioDTO> lista = rehes.comenzarRutinaDeEjercicios(id);
        
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @Autowired
    private RutinaEjercicioServicio res;

    @GetMapping("/buscar")
    public ResponseEntity<List<RutinaEjercicio>> buscarRutinasDeEjercicios(
            @RequestParam(value = "frase", required = false, defaultValue = "") String frase,
            @RequestParam(value = "nivel", required = false, defaultValue = "") String nivel,
            @RequestParam(value = "tipo", required = false, defaultValue = "") String tipo) {
        List<RutinaEjercicio> lista = res.buscarRutinasDeEjercicios(frase, nivel, tipo);

        return new ResponseEntity(lista, HttpStatus.OK);
    }
}
