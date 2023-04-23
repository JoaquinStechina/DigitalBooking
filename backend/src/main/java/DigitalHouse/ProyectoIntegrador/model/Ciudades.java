package DigitalHouse.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="ciudades")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombreCiudad;

    @Column
    private String nombrePais;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ciudad")
    @JsonIgnore
    private Set<Producto> productos;
}
