package DigitalHouse.ProyectoIntegrador.service;

import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import DigitalHouse.ProyectoIntegrador.repository.UsuariosRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuariosDetailsService implements UserDetailsService {
    private final UsuariosRepository usuariosRepository;
    final static Logger logger = LogManager.getLogger(UsuariosDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuario = this.usuariosRepository.findByEmail(email);
        logger.info("Se encontro el usuario con el email "+usuario.getEmail()+" ; Con el rol "+usuario.getRol());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+usuario.getRol()));

        UserDetails userDetails = new User(usuario.getEmail(),usuario.getContrasena(),authorities);
        return userDetails;
    }
}
