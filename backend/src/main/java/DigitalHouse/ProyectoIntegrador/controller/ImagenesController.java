package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Imagenes;
import DigitalHouse.ProyectoIntegrador.service.ImagenesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin("*")
@AllArgsConstructor
public class ImagenesController {
    private final ImagenesService imagenesService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Imagenes> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.imagenesService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Imagenes> save(@RequestBody Imagenes imagenes) throws BadRequestException {
        return new ResponseEntity<>(this.imagenesService.save(imagenes),HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<List<Imagenes>> getAll(){
        return new ResponseEntity<>(this.imagenesService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Imagenes> update(@RequestBody Imagenes imagenes) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.imagenesService.update(imagenes),HttpStatus.OK );
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.imagenesService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la imagen con el id "+id);
    }
}
