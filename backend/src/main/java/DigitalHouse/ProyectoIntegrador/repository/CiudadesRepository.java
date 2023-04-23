package DigitalHouse.ProyectoIntegrador.repository;

import DigitalHouse.ProyectoIntegrador.model.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {
}
