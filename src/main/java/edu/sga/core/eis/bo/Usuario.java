package edu.sga.core.eis.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(exclude = "rol")
public class Usuario implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Long codigoUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "codigo_rol",referencedColumnName = "codigo_rol")
    private Rol rol;

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList();
        roles.add(this.rol);
        return roles;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
