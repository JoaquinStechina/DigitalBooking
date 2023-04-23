package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Categorias;
import DigitalHouse.ProyectoIntegrador.service.CategoriasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoriasController {
    private final CategoriasService categoriasService;

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.categoriasService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorias> save(@RequestBody Categorias categorias) throws BadRequestException{
        return new ResponseEntity<>(categoriasService.save(categorias), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> getAll(){
        return new ResponseEntity<>(categoriasService.getAll(),HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        categoriasService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado la categoria con el id "+id);
    }

    @PutMapping
    public ResponseEntity<Categorias> update(@RequestBody Categorias categorias) throws ResourceNotFoundException {
        return new ResponseEntity<>(categoriasService.update(categorias),HttpStatus.OK);
    }
}
