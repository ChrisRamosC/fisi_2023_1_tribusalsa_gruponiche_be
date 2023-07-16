/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.repositorios;

import com.gruponiche.fitorfat.hu16y17.entidades.CompetenciaRutina;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extendemos las operaciones disponibles del repositorio 
 * de jpa para la clase objetivo, para ello especificamos los tipos de datos
 */
public interface CompetenciaRepositorio extends JpaRepository<CompetenciaRutina,Integer>{
    
    
}
