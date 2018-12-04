package edu.sga.core.eis.bo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Data
@Entity
@Table(name="clase")
@EqualsAndHashCode(exclude = {"profesorCurso","grupoAcademico","salon","claseAlumnos","profesor"})
public class Clase implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo_clase")
	private Long codigoClase;
	@Column(name="nombre")
	private String nombre;
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	@Column(name="hora_inicio")
	private Date horaInicio;
	@Column(name="hora_fin")
	private Date horaFin;
	@Column(name="fecha_inicio")	
	private Date fechaInicio;
	@Column(name="fecha_final")
	private Date fechaFinal;
	@Column(name="codigo_profesor",nullable=false,insertable=false,updatable=false)
	private Long codigoProfesor;
	@Column(name="codigo_curso",nullable=false,insertable=false,updatable=false)
	private Long codigoCurso;
	@ManyToOne
	@JoinColumns(
	{
		@JoinColumn(name="codigo_profesor",
				referencedColumnName="codigo_profesor",
				nullable=false,
				insertable=false,
				updatable=false)
		,@JoinColumn(name="codigo_curso",referencedColumnName="codigo_curso",nullable=false,insertable=false,updatable=false)
	})
	private ProfesorCurso profesorCurso;	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_grupo_academico")
	private GrupoAcademico grupoAcademico;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_salon")
	private Salon salon;	
	@OneToMany(mappedBy="clase")
	private Set<ClaseAlumno> claseAlumnos = new HashSet<ClaseAlumno>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_profesor")
	private Profesor profesor;
}
