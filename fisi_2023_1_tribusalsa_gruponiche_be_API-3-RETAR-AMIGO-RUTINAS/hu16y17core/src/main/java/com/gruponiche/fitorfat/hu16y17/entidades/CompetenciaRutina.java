/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.entidades;



import com.gruponiche.fitorfat.hu16y17.entidades.enums.EstadoSolicitud;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="competencia_rutina")
@Getter
@Setter
public class CompetenciaRutina {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompetencia_Rutina;

    @Column
    private Integer invitado;

    @Column
    private OffsetDateTime fecha_inicio;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud" , columnDefinition="ENUM('aceptado', 'rechazado', 'enviado')")
    private EstadoSolicitud estadoSolicitud;

    @Column
    private Integer ganador;
    
    @Column
    private Integer rutina_ejercicio_id;
    
    @Column
    private Integer usuario_codigo;

}
