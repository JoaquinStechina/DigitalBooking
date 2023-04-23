package DigitalHouse.ProyectoIntegrador.dto;
import DigitalHouse.ProyectoIntegrador.model.Producto;
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
public class CiudadesDTO{
    private long id;
    private String nombreCiudad;
    private String nombrePais;
    private Set<Producto> productos;
}
