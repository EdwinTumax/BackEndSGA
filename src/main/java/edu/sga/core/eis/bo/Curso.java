package edu.sga.core.eis.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name="curso")
@EqualsAndHashCode(exclude = "profesorCursos")
public class Curso implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo_curso")
	private Long codigoCurso;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="numero_alumnos")
	private int numeroAlumnos;
	@OneToMany(mappedBy = "curso")
	private Set<ProfesorCurso> profesorCursos = new HashSet<ProfesorCurso>();
}
