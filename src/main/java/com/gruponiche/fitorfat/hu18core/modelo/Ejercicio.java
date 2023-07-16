package com.gruponiche.fitorfat.hu18core.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ejercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ejercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Integer idEjercicio;

    @Column(name = "nombre_esp")
    private String nombreEsp;

    @Column(name = "nombre_ing")
    private String nombreIng;

    @Column(name = "informacion")
    private String informacion;

    @Column(name = "link_video")
    private String linkVideo;
     
    @Column(name = "gif")
    private String gif;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_muscular_id_grupo_muscular", referencedColumnName = "id_grupo_muscular")
    private GrupoMuscular grupoMuscularIdGrupoMuscular;

    @Column(name = "nivel_ejercicio")
    private String nivelEjercicio;
}
