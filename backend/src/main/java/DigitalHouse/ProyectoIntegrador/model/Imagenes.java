package DigitalHouse.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="imagenes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Imagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonIgnore
    private Producto producto;
}
