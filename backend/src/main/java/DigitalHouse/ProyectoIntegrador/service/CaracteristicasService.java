package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Caracteristicas;
import DigitalHouse.ProyectoIntegrador.repository.CaracteristicasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CaracteristicasService implements ICaracteristicasService{
    private final CaracteristicasRepository caracteristicasRepository;
    @Override
    public Caracteristicas findById(Long id) throws ResourceNotFoundException {
        return this.caracteristicasRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la caracteristica con el id" + id));
    }

    @Override
    public Caracteristicas save(Caracteristicas caracteristicas) throws BadRequestException {
        if(caracteristicas == null){
            throw new BadRequestException("La categoria pasada es nula");
        }
        else{
            return caracteristicasRepository.save(caracteristicas);
        }
    }

    @Override
    public List<Caracteristicas> getAll() {
        return caracteristicasRepository.findAll();
    }

    @Override
    public Caracteristicas update(Caracteristicas caracteristicas) throws ResourceNotFoundException {
        this.findById(caracteristicas.getId());
        caracteristicasRepository.save(caracteristicas);
        return caracteristicas;
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        caracteristicasRepository.deleteById(id);
    }
}
