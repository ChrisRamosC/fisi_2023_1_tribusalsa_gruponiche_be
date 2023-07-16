package com.gruponiche.fitorfat.hu18core.modelo.dto;

import javax.persistence.Column;
import lombok.Value;

@Value
public class EjercicioDTO {
        
    @Column(name = "nombre_ejercicio")
    private String nombre_ejercicio;
    
    @Column(name = "descripcion_ejercicio")
    private String descripcion_ejercicio;
    
    @Column(name = "video")
    private String video;
    
    @Column(name = "gif")
    private String gif;
    
    @Column(name = "grupo_muscular")
    private Integer grupo_muscular;
    
    @Column(name = "nivel_ejercicio")
    private String nivel_ejercicio;
    
    @Column(name = "repeticiones")
    private Integer repeticiones;
    
    @Column(name = "duracion_seg")
    private String duracion_seg;
    
    @Column(name = "descanso_seg")
    private Integer descanso_seg;
}