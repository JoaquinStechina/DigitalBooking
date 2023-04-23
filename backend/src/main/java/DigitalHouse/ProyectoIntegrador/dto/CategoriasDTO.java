package DigitalHouse.ProyectoIntegrador.dto;

import DigitalHouse.ProyectoIntegrador.model.Producto;

import java.io.Serializable;
import java.util.Set;

public class CategoriasDTO implements Serializable {
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;
    private Set<Producto> productos;
}
