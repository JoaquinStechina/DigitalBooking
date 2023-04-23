package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Producto;
import DigitalHouse.ProyectoIntegrador.repository.CategoriasRepository;
import DigitalHouse.ProyectoIntegrador.repository.CiudadesRepository;
import DigitalHouse.ProyectoIntegrador.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService{
    private final ProductoRepository productoRepository;
    private final CategoriasRepository categoriasRepository;
    private final CiudadesRepository ciudadesRepository;

    @Override
    public Producto findById(Long id) throws ResourceNotFoundException {
        return productoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado el producto con el id "+id));
    }
    @Override
    public Producto save(Producto producto) throws BadRequestException {
        if(producto==null || producto.getId() == null){
            throw new BadRequestException("El producto pasado es nulo");
        }
        else{
            return productoRepository.save(producto);
        }
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto update(Producto producto) throws ResourceNotFoundException {
        this.findById(producto.getId());
        productoRepository.save(producto);
        return producto;
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> getProductsByCategory(Long categoria_id) throws ResourceNotFoundException {
        categoriasRepository.findById(categoria_id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la categoria con el id "+categoria_id));
        return productoRepository.getProductsByCategory(categoria_id);
    }

    @Override
    public List<Producto> getProductsByCiudad(Long ciudad_id) throws ResourceNotFoundException {
        ciudadesRepository.findById(ciudad_id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la ciudad con el id "+ciudad_id));
        return productoRepository.getProductsByCity(ciudad_id);
    }

}
