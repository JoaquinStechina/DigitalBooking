package DigitalHouse.ProyectoIntegrador.controller;

import DigitalHouse.ProyectoIntegrador.configuration.PasswordEncoder;
import DigitalHouse.ProyectoIntegrador.model.AutenticacionPeticion;
import DigitalHouse.ProyectoIntegrador.model.AutenticacionRespuesta;
import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import DigitalHouse.ProyectoIntegrador.repository.UsuariosRepository;
import DigitalHouse.ProyectoIntegrador.service.UsuariosDetailsService;
import DigitalHouse.ProyectoIntegrador.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autenticar")
@AllArgsConstructor
@CrossOrigin("*")
public class AutenticacionController {
    private JwtUtil jwtUtil;
    private UsuariosDetailsService usuariosDetailsService;
    private UsuariosRepository usuariosRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AutenticacionPeticion autenticacionPeticion) throws Exception {
        Usuarios usuario = this.usuariosRepository.findByEmail(autenticacionPeticion.getUsername());

        if (usuario != null && passwordEncoder.BCryptPasswordEncoder().matches(autenticacionPeticion.getPassword(),usuario.getPassword())){
            final UserDetails userDetails = usuariosDetailsService.loadUserByUsername(autenticacionPeticion.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AutenticacionRespuesta((jwt), usuario.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
