package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.dto.UsuariosDTO;
import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;
import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import DigitalHouse.ProyectoIntegrador.repository.UsuariosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    private final UsuariosRepository usuariosRepository;
    private final ObjectMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UsuariosDTO findById(Long id) throws ResourceNotFoundException {
        Optional<Usuarios> usuario = Optional.ofNullable(this.usuariosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el usuario con el id " + id)));
        return this.mapper.convertValue(usuario, UsuariosDTO.class);
    }

    @Override
    public UsuariosDTO save(UsuariosDTO usuariosDTO) throws BadRequestException {
        usuariosDTO.setContrasena(passwordEncoder.encode(usuariosDTO.getContrasena()));
        if(this.camposCompletos(usuariosDTO)){
            this.usuariosRepository.save(mapper.convertValue(usuariosDTO,Usuarios.class));
            return usuariosDTO;
        }
        else{
            throw new BadRequestException("El usuario no tiene todos los campos completos");
        }
    }

    @Override
    public List<UsuariosDTO> getAll() {
        List<UsuariosDTO> usuariosDTOS;
        List<Usuarios> usuarios = this.usuariosRepository.findAll();
        usuariosDTOS = usuarios.stream().map(UsuariosDTO::new).collect(Collectors.toList());
        return usuariosDTOS;
    }

    @Override
    public UsuariosDTO update(UsuariosDTO usuariosDTO) throws ResourceNotFoundException, BadRequestException {
        this.findById(usuariosDTO.getId());
        if(this.camposCompletos(usuariosDTO)){
            this.usuariosRepository.save(mapper.convertValue(usuariosDTO,Usuarios.class));
            return usuariosDTO;
        }
        else{
            throw new BadRequestException("El usuario no tiene todos los campos completos");
        }
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        this.findById(id);
        this.usuariosRepository.deleteById(id);
    }

    private boolean camposCompletos(UsuariosDTO usuariosDTO){
        boolean camposCompletos = usuariosDTO.getId() != null;
        camposCompletos &= usuariosDTO.getContrasena() != null;
        camposCompletos &= usuariosDTO.getNombre() != null;
        camposCompletos &= usuariosDTO.getEmail() != null;
        camposCompletos &= usuariosDTO.getRol() != null;
        camposCompletos &= usuariosDTO.getCiudad() != null;

        return camposCompletos;
    }
}
