package DigitalHouse.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String direccion;

    @Column
    private Integer distancia;

    @Column
    private Integer puntos;

    @Column
    private String puntosTexto;

    @Column
    private Integer numeroHabitacion;

    @Column(length = 1000)
    private String politicasCancelacion;

    @Column(length = 1000)
    private String politicasSaludSeguridad;

    @Column(length = 1000)
    private String politicasCasa;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Imagenes> imagenes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Reservas> reservas;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "Producto_Caracteristica",
            joinColumns = { @JoinColumn(name = "producto_id") },
            inverseJoinColumns = { @JoinColumn(name = "caracteristica_id") }
    )
    private Set<Caracteristicas> caracteristicas;

    @ManyToOne
    @JoinColumn(name="ciudad_id")
    private Ciudades ciudad;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categorias categoria;
}
