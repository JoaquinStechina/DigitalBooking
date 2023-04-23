package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Ciudades;
import DigitalHouse.ProyectoIntegrador.repository.CiudadesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CiudadesService implements ICiudadesService{
    private final CiudadesRepository ciudadesRepository;

    @Override
    public Ciudades findById(Long id) throws ResourceNotFoundException {
        return this.ciudadesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la ciudad con el id "+id));
    }

    @Override
    public Ciudades save(Ciudades ciudades) throws BadRequestException {
        if(ciudades == null){
            throw new BadRequestException("La categoria pasada es nula");
        }
        else{
            return this.ciudadesRepository.save(ciudades);
        }
    }

    @Override
    public List<Ciudades> getAll() {
        return this.ciudadesRepository.findAll();
    }

    @Override
    public Ciudades update(Ciudades ciudades) throws ResourceNotFoundException {
        this.findById(ciudades.getId());
        this.ciudadesRepository.save(ciudades);
        return ciudades;
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        this.ciudadesRepository.deleteById(id);
    }
}
