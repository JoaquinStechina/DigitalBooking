package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Reservas;

import java.util.List;

public interface IReservasService {
    Reservas findById(Long id) throws ResourceNotFoundException;
    Reservas save(Reservas reservas) throws BadRequestException;
    List<Reservas> getAll();
    Reservas update(Reservas reservas) throws ResourceNotFoundException, BadRequestException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
