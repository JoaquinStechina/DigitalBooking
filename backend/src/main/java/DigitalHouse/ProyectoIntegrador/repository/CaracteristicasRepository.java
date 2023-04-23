package DigitalHouse.ProyectoIntegrador.repository;

import DigitalHouse.ProyectoIntegrador.model.Caracteristicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasRepository extends JpaRepository<Caracteristicas, Long> {
}
