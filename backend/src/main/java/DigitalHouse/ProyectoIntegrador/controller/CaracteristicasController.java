package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Caracteristicas;
import DigitalHouse.ProyectoIntegrador.service.CaracteristicasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/caracteristicas")
@CrossOrigin("*")
public class CaracteristicasController {
    private final CaracteristicasService caracteristicasService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Caracteristicas> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(caracteristicasService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Caracteristicas> save(@RequestBody Caracteristicas caracteristicas) throws BadRequestException {
        return new ResponseEntity<>(caracteristicasService.save(caracteristicas),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Caracteristicas>> getAll(){
        return new ResponseEntity<>(caracteristicasService.getAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Caracteristicas> update(@RequestBody Caracteristicas caracteristicas) throws ResourceNotFoundException {
        return new ResponseEntity<>(caracteristicasService.update(caracteristicas),HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.caracteristicasService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la caracteristica con el id "+id);
    }
}
