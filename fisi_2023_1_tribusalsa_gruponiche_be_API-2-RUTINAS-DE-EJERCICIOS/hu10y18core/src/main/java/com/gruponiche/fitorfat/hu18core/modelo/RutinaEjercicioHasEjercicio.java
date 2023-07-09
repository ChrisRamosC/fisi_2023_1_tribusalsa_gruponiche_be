package com.gruponiche.fitorfat.hu18core.modelo;

import com.gruponiche.fitorfat.hu18core.modelo.dto.EjercicioDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "RutinaEjercicioHasEjercicio.comenzarRutinaDeEjercicios",
                  query = "{call comenzar_rutina_de_ejercicios(:rutina)}",
                  resultSetMapping = "Mapping.EjercicioDTO")
@SqlResultSetMapping(name = "Mapping.EjercicioDTO",
                     classes = @ConstructorResult(targetClass = EjercicioDTO.class,
                                                  columns = {@ColumnResult(name = "nombre_ejercicio"),
                                                             @ColumnResult(name = "descripcion_ejercicio"),
                                                             @ColumnResult(name = "video"),
                                                             @ColumnResult(name = "gif"),
                                                             @ColumnResult(name = "grupo_muscular"),
                                                             @ColumnResult(name = "nivel_ejercicio"),
                                                             @ColumnResult(name = "repeticiones"),
                                                             @ColumnResult(name = "duracion_seg"),
                                                             @ColumnResult(name = "descanso_seg")}))
@Entity
@Table(name = "rutinaejercicio_has_ejercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicioHasEjercicio implements Serializable {
    
    @EmbeddedId
    private RutinaEjercicioHasEjercicioPKId rutinaId;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "duracion_seg")
    private String duracionSeg;

    @Column(name = "descanso_seg")
    private Integer descansoSeg;
}
