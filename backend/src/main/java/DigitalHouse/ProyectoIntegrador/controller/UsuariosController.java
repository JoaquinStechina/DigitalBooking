package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.dto.UsuariosDTO;
import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsuariosController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDTO> findById(@PathVariable long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuariosDTO> save(@RequestBody UsuariosDTO usuariosDTO) throws BadRequestException {
        return new ResponseEntity<>(this.userService.save(usuariosDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> getAll(){
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UsuariosDTO> update(@RequestBody UsuariosDTO usuariosDTO) throws BadRequestException, ResourceNotFoundException {
        return new ResponseEntity<>(this.userService.update(usuariosDTO),HttpStatus.OK );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        this.userService.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el usuario con el id "+id);
    }
}
