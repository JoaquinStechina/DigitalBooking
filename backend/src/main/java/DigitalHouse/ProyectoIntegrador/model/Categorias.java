package DigitalHouse.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="categorias")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String url;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos;
}
