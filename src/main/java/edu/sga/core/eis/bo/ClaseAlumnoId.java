package edu.sga.core.eis.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class ClaseAlumnoId implements Serializable {
	@Column(name="codigo_clase",nullable=false,insertable=false,updatable=false)
	private Long codigoClase;
	@Column(name="codigo_alumno",nullable=false,insertable=false,updatable=false)
	private Long codigoAlumno;
}
