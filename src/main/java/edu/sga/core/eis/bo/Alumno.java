package edu.sga.core.eis.bo;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "alumno")
@EqualsAndHashCode(exclude = {"carrera","claseAlumnos"})
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "codigo_alumno")
    private Long codigoAlumno;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name="nombres")
    private String nombres;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name="carne")
    private String carne;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_carrera")
    private Carrera carrera;
    @OneToMany(mappedBy="alumno")
    private Set<ClaseAlumno> claseAlumnos = new HashSet<ClaseAlumno>();
}

