package DigitalHouse.ProyectoIntegrador.repository;

import DigitalHouse.ProyectoIntegrador.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByEmail(String email);
}
