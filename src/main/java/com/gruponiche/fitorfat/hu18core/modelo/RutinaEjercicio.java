package com.gruponiche.fitorfat.hu18core.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "RutinaEjercicio.buscarRutinasDeEjercicios",
                  query = "{call buscar_rutinas_de_ejercicios(:frase,:nivel,:tipo)}",
                  resultSetMapping = "Mapping.RutinaEjercicio")
@SqlResultSetMapping(name = "Mapping.RutinaEjercicio",
                     classes = @ConstructorResult(targetClass = RutinaEjercicio.class,
                                                  columns = {@ColumnResult(name = "id_rutina_ejercicio"),
                                                             @ColumnResult(name = "nombre_rutina"),
                                                             @ColumnResult(name = "duracion_rutina"),
                                                             @ColumnResult(name = "descripcion"),
                                                             @ColumnResult(name = "link_imagen"),
                                                             @ColumnResult(name = "nivel_rutina"),
                                                             @ColumnResult(name = "tipo_rutina"),
                                                             @ColumnResult(name = "fuera_de_casa")}))
@Entity
@Table(name = "rutina_ejercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina_ejercicio")
    private Integer id_rutina_ejercicio;

    @Column(name = "nombre_rutina")
    private String nombre_rutina;

    @Column(name = "duracion_rutina")
    private Double duracion_rutina;

    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "link_imagen")
    private String linkImagen;

    @Column(name = "nivel_rutina")
    private String nivel_rutina;

    @Column(name = "tipo_rutina")
    private String tipo_rutina;

    @Column(name = "fuera_de_casa", nullable = false, columnDefinition = "BOOLEAN", length = 1)
    private Boolean fuera_de_casa;
}