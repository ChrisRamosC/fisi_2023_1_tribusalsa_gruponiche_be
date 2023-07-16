/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gruponiche.fitorfat.hu16y17.entidades;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(length = 45)
    private String telefono;

    @Column(nullable = false, length = 45)
    private String correo;

    @Column(nullable = false, length = 150)
    private String contrasena;

    @Column(nullable = false)
    private Boolean es_Premium;

    @Column(nullable = false)
    private Boolean es_autenticado;

    @Column(columnDefinition = "mediumblob")
    private String imagen;

    @Column(length = 6)
    private String codigo_verificacion;

    @Column
    private OffsetDateTime expiracion_codigo;

    

}