package com.gruponiche.fitorfat.hu18core.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grupo_muscular")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoMuscular implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_muscular")
    private Integer idGrupoMuscular;
    
    @Column(name = "gmuscular")
    private String gmuscular;
    
    @Column(name = "link_imagen")
    private String linkImagen;
}
