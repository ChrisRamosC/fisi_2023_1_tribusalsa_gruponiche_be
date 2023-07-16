package com.gruponiche.fitorfat.hu18core.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RutinaEjercicioHasEjercicioPKId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rutina_ejercicio_id_rutina_ejercicio", referencedColumnName = "id_rutina_ejercicio")
    private RutinaEjercicio rutinaEjercicioIdRutinaEjercicio;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ejercicio_id_ejercicio", referencedColumnName = "id_ejercicio")
    private Ejercicio ejercicioIdEjercicio;
}
