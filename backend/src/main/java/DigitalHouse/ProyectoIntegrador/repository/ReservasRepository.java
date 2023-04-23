package DigitalHouse.ProyectoIntegrador.repository;

import DigitalHouse.ProyectoIntegrador.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {
}
