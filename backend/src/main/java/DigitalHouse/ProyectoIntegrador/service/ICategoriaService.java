package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Categorias;

import java.util.List;

public interface ICategoriaService {
    Categorias findById(Long id) throws ResourceNotFoundException;
    Categorias save(Categorias categorias) throws BadRequestException;
    List<Categorias> getAll();
    Categorias update(Categorias categorias) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
