package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Ciudades;

import java.util.List;

public interface ICiudadesService {
    Ciudades findById(Long id) throws ResourceNotFoundException;
    Ciudades save(Ciudades ciudades) throws BadRequestException;
    List<Ciudades> getAll();
    Ciudades update(Ciudades ciudades) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
