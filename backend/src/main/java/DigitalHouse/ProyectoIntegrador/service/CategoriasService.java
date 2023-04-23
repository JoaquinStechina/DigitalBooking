package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Categorias;
import DigitalHouse.ProyectoIntegrador.repository.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriasService implements ICategoriaService {
    private final CategoriasRepository categoriasRepository;

    @Override
    public Categorias findById(Long id) throws ResourceNotFoundException {
        return this.categoriasRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la categoria con el id "+id));
    }

    //Guardar
    public Categorias save(Categorias categorias) throws BadRequestException {
        if(categorias == null){
            throw new BadRequestException("La categoria pasada es nula");
        }
        else{
            return this.categoriasRepository.save(categorias);
        }
    }

    //Listar todas
    public List<Categorias> getAll(){
        return categoriasRepository.findAll();
    }

    //Actualizar
    public Categorias update(Categorias categorias) throws ResourceNotFoundException {
        this.findById(categorias.getId());
        this.categoriasRepository.save(categorias);
        return categorias;
    }

    //Eliminar por ID
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        this.categoriasRepository.deleteById(id);
    }
}
