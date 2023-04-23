package DigitalHouse.ProyectoIntegrador.dto;

import DigitalHouse.ProyectoIntegrador.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDTO implements Serializable {
    private Long id;
    private String nombre;
    private String titulo;
    private String descripcion;
    private String direccion;
    private Integer distancia;
    private Integer puntos;
    private String puntosTexto;
    private Integer numeroHabitacion;
    private Set<Imagenes> imagenes;
    private Set<Reservas> reservas;
    private Set<Caracteristicas> caracteristicas;
    private Ciudades ciudad;
    private Categorias categoria;
}
