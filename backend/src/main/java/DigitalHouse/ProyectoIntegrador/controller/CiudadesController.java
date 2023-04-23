package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Ciudades;
import DigitalHouse.ProyectoIntegrador.service.CiudadesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
@AllArgsConstructor
@CrossOrigin("*")
public class CiudadesController {
    private final CiudadesService ciudadesService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Ciudades> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ciudadesService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ciudades> save(@RequestBody Ciudades ciudades) throws BadRequestException {
        return new ResponseEntity<>(this.ciudadesService.save(ciudades), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ciudades>> getAll(){
        return new ResponseEntity<>(this.ciudadesService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Ciudades> update(@RequestBody Ciudades ciudades) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ciudadesService.update(ciudades),HttpStatus.OK );
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.ciudadesService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la ciudad con el id "+id);
    }
}
