package DigitalHouse.ProyectoIntegrador.dto;

import DigitalHouse.ProyectoIntegrador.model.Roles;
import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuariosDTO implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String ciudad;
    private Roles rol;
    private String jwt;

    public UsuariosDTO(Usuarios usuarios) {
        this.id = usuarios.getId();
        this.nombre = usuarios.getNombre();
        this.apellido = usuarios.getApellido();
        this.email = usuarios.getEmail();
        this.contrasena = usuarios.getContrasena();
        this.ciudad = usuarios.getCiudad();
        this.rol = usuarios.getRol();
        this.jwt = usuarios.getJwt();
    }

    public UsuariosDTO(Long id, String nombre, String apellido, String email, String contrasena, String ciudad, Roles rol){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.ciudad = ciudad;
        this.rol = rol;
    }
}
