package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Reservas;
import DigitalHouse.ProyectoIntegrador.repository.ReservasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservasService implements IReservasService{
    private final ReservasRepository reservasRepository;

    @Override
    public Reservas findById(Long id) throws ResourceNotFoundException {
        return this.reservasRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado la reserva con el id "+id));
    }

    @Override
    public Reservas save(Reservas reservas) throws BadRequestException {
        if(reservas==null || reservas.getId() == null){
            throw new BadRequestException("La imagen pasada es nula");
        }
        else{
            return this.reservasRepository.save(reservas);
        }
    }

    @Override
    public List<Reservas> getAll() {
        return this.reservasRepository.findAll();
    }

    @Override
    public Reservas update(Reservas reservas) throws ResourceNotFoundException, BadRequestException {
        this.findById(reservas.getId());
        return this.save(reservas);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        this.reservasRepository.deleteById(id);
    }
}
