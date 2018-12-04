package edu.sga.core.eis.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable, GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_rol")
    private  Long codigoRol;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    @Override
    public String getAuthority() {
        return this.nombre;
    }
}
