/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.controladores;

import com.gruponiche.fitorfat.hu16y17.entidades.CompetenciaRutina;
import com.gruponiche.fitorfat.hu16y17.servicios.CompetenciaServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase para manejar las solicitudes vía REST
 */
@RestController

@RequestMapping("/ux-retar-amigo-rutinas/fitorfat/servicio-al-cliente/v1/competencias")
@AllArgsConstructor
public class CompetenciaControlador {
    private final CompetenciaServicio compServ;

    @PostMapping
    public CompetenciaRutina guardarCompetencia(@RequestBody CompetenciaRutina c) {

        return compServ.guardarCompetencia(c);
    }

    @GetMapping("/listar-competencias")
    public List<CompetenciaRutina> getCompetencias() {
        return compServ.listarCompetencias();
    }


}
