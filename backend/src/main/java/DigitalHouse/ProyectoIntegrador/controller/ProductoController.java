package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Producto;
import DigitalHouse.ProyectoIntegrador.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(productoService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) throws BadRequestException {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        return new ResponseEntity<>(productoService.getAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Producto> update(@RequestBody Producto producto) throws ResourceNotFoundException {
        return new ResponseEntity<>(productoService.update(producto),HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.productoService.deleteById(id);
        return new ResponseEntity<>("Se elimino el producto con el id "+id, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/categorias/{id}")
    public ResponseEntity<List<Producto>> getProductByCategoryId (@PathVariable Long id) throws ResourceNotFoundException{
        return new ResponseEntity<>(productoService.getProductsByCategory(id),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/ciudades/{id}")
    public ResponseEntity<List<Producto>> getProductByCityId (@PathVariable Long id) throws ResourceNotFoundException{
        return new ResponseEntity<>(productoService.getProductsByCiudad(id),HttpStatus.OK);
    }
}
