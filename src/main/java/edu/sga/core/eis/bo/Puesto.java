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

@Entity
@Table(name="puesto")
@Data
@EqualsAndHashCode(exclude = "profesores")
public class Puesto implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="codigo_puesto")
	private Long codigoPuesto;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy = "puesto")
	private Set<Profesor> profesores = new HashSet<Profesor>();
}
