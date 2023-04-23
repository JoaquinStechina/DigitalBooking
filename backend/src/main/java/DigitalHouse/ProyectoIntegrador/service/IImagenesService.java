package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Imagenes;

import java.util.List;

public interface IImagenesService {
    Imagenes findById(Long id) throws ResourceNotFoundException;
    Imagenes save(Imagenes imagenes) throws BadRequestException;
    List<Imagenes> getAll();
    Imagenes update(Imagenes imagenes) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
