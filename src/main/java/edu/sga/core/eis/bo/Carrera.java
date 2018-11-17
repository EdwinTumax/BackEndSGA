package edu.sga.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_carrera")
    private  Long codigoCarrera;
    @Column(name = "descripcion")
    private  String descripcion;
}
