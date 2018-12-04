package edu.sga.core.eis.bo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="clase_alumno")
@EqualsAndHashCode(exclude = {"alumno","clase"})
public class ClaseAlumno implements Serializable {
	@EmbeddedId
	private ClaseAlumnoId claseAlumnoId;
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_alumno",
	 referencedColumnName="codigo_alumno",nullable=false,
	 insertable=false,updatable=false)
	@JsonIgnore
	private Alumno alumno;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_clase",
	 referencedColumnName="codigo_clase",nullable=false,
	 insertable=false,updatable=false)
	@JsonIgnore
	private Clase clase;
}
