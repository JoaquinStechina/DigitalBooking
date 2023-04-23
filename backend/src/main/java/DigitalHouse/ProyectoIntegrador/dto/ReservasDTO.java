package DigitalHouse.ProyectoIntegrador.dto;

import DigitalHouse.ProyectoIntegrador.model.Producto;
import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservasDTO implements Serializable {
    private Long id;
    private LocalTime hora_comienzo;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Producto producto;
    private Usuarios usuario;
}
