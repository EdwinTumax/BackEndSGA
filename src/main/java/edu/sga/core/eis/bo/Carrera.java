package edu.sga.core.eis.bo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="carrera")
@EqualsAndHashCode(exclude = "alumnos")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_carrera")
    private Long codigoCarrera;
    @Column(name = "descripcion")
    private String descripcion;
    @JsonIgnore
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private Set<Alumno> alumnos = new HashSet<Alumno>();
}

