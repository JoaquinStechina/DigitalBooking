package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.dto.UsuariosDTO;
import DigitalHouse.ProyectoIntegrador.exceptions.BadRequestException;
import DigitalHouse.ProyectoIntegrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IUserService {
    UsuariosDTO findById(Long id) throws ResourceNotFoundException;
    UsuariosDTO save(UsuariosDTO usuariosDTO) throws BadRequestException;
    List<UsuariosDTO> getAll();
    UsuariosDTO update(UsuariosDTO usuariosDTO) throws ResourceNotFoundException, BadRequestException;
    void deleteById(Long id) throws ResourceNotFoundException;
}
