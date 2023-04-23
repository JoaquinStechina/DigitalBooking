package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Caracteristicas;
import DigitalHouse.ProyectoIntegrador.model.Categorias;

import java.util.List;

public interface ICaracteristicasService {
    Caracteristicas findById(Long id) throws ResourceNotFoundException;
    Caracteristicas save(Caracteristicas caracteristicas) throws BadRequestException;
    List<Caracteristicas> getAll();
    Caracteristicas update(Caracteristicas caracteristicas) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
