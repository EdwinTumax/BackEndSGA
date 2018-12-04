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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Data
@Entity
@Table(name="profesor")
@EqualsAndHashCode(exclude = {"profesorCursos","puesto"})
public class Profesor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo_profesor")
	private Long codigoProfesor;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="nombres")
	private String nombres;
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name="numero_periodos")
	private int numeroPeriodos;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_puesto")
	private Puesto puesto;
	@OneToMany(mappedBy="profesor")
	private Set<ProfesorCurso> profesorCursos = new HashSet<ProfesorCurso>();
}
