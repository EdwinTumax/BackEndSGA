package edu.sga.core.eis.bo;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "grupo_academico")
@EqualsAndHashCode(exclude = "clases")
public class GrupoAcademico implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_grupo_academico")
	private Long codigoGrupoAcademico;
	@Column(name="descripcion")
	@JsonIgnore
	@OneToMany(mappedBy = "grupoAcademico")
	private Set<Clase> clases = new HashSet<Clase>();
	private String descripcion;
}
