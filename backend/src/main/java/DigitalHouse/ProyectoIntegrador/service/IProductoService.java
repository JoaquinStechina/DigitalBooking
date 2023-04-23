package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto findById(Long id) throws ResourceNotFoundException;
    Producto save(Producto producto) throws BadRequestException;
    List<Producto> getAll();
    Producto update(Producto producto) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
    List<Producto> getProductsByCategory(Long categoria_id) throws ResourceNotFoundException;
    List<Producto> getProductsByCiudad(Long ciudad_id) throws ResourceNotFoundException;
}
