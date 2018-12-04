package edu.sga.core.eis.bo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name="salon")
public class Salon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo_salon")
	private Long codigoSalon;
	@Column(name="salon")
	private String salon;
	@Column(name="unidad")
	private int unidad;
}
