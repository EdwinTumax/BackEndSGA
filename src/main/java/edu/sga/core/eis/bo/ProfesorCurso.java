package edu.sga.core.eis.bo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="profesor_curso")
@EqualsAndHashCode(exclude = {"profesor","curso"})
public class ProfesorCurso {
	@EmbeddedId
	private ProfesorCursoId profesorCursoId;
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;
	@ManyToOne
	@JoinColumn(name="codigo_profesor",
	referencedColumnName = "codigo_profesor",
	nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Profesor profesor;
	@ManyToOne
	@JoinColumn(name="codigo_curso",
	referencedColumnName="codigo_curso",
	nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Curso curso;
}
