package edu.sga.core.eis.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProfesorCursoId implements Serializable {
	@Column(name="codigo_profesor",nullable=false,insertable=false,updatable=false)
	private Long codigoProfesor;
	@Column(name="codigo_curso",nullable=false,insertable=false,updatable=false)
	private Long codigoCurso;
}
