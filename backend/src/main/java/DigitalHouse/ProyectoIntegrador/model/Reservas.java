package DigitalHouse.ProyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalTime hora_comienzo;

    @Column
    private LocalDate checkIn;

    @Column
    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private Producto producto;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuarios usuario;
}
