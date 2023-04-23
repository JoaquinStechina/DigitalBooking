package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Imagenes;
import DigitalHouse.ProyectoIntegrador.repository.ImagenesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImagenesService implements IImagenesService{
    private final ImagenesRepository imagenesRepository;
    @Override
    public Imagenes findById(Long id) throws ResourceNotFoundException {
        return this.imagenesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la imagen con el id "+id));
    }

    @Override
    public Imagenes save(Imagenes imagenes) throws BadRequestException {
        if(imagenes==null || imagenes.getId() == null){
            throw new BadRequestException("La imagen pasada es nula");
        }
        else{
            return this.imagenesRepository.save(imagenes);
        }
    }

    @Override
    public List<Imagenes> getAll() {
        return this.imagenesRepository.findAll();
    }

    @Override
    public Imagenes update(Imagenes imagenes) throws ResourceNotFoundException {
        this.findById(imagenes.getId());
        return this.imagenesRepository.save(imagenes);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        this.imagenesRepository.deleteById(id);
    }
}
