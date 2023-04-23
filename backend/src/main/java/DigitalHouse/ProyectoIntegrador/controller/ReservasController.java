package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Imagenes;
import DigitalHouse.ProyectoIntegrador.model.Reservas;
import DigitalHouse.ProyectoIntegrador.service.ReservasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin("*")
@AllArgsConstructor
public class ReservasController {
    private final ReservasService reservasService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Reservas> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.reservasService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservas> save(@RequestBody Reservas reservas) throws BadRequestException {
        return new ResponseEntity<>(this.reservasService.save(reservas),HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<List<Reservas>> getAll(){
        return new ResponseEntity<>(this.reservasService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Reservas> update(@RequestBody Reservas reservas) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(this.reservasService.update(reservas),HttpStatus.OK );
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.reservasService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la reserva con el id "+id);
    }
}
