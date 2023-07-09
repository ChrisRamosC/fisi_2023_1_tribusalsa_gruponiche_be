/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.servicios;

import com.gruponiche.fitorfat.hu16y17.entidades.CompetenciaRutina;
import com.gruponiche.fitorfat.hu16y17.entidades.enums.EstadoSolicitud;
import com.gruponiche.fitorfat.hu16y17.repositorios.CompetenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Clase para mapear e implementar operaciones
 *  para la clase objetivo con el servicio 
 *  del repositorio o sin este
 * 
 */
@Service
public class CompetenciaServicio {
    @Autowired
    private CompetenciaRepositorio repoC;
    public CompetenciaRutina guardarCompetencia(CompetenciaRutina c){
        // Por defecto se pone como enviado
        c.setEstadoSolicitud(EstadoSolicitud.ENVIADO);
        return repoC.save(c);
    }
    public List<CompetenciaRutina> listarCompetencias(){
        return repoC.findAll();
    }

}
