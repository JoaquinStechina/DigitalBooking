package DigitalHouse.ProyectoIntegrador.repository;

import DigitalHouse.ProyectoIntegrador.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query("select p from Producto p where p.categoria.id = ?1")
    List<Producto> getProductsByCategory(Long category_id);

    @Query("select p from Producto p where p.ciudad.id = ?1")
    List<Producto> getProductsByCity(Long city_id);

    @Query(
            value = "select P.* from Producto P " +
                    "where P.ciudad_id = :ciudadId " +
                    "and P.id not in ( " +
                    "select distinct R.producto_id " +
                    "from reservas R " +
                    "where (R.checkOut > :checkIn and R.checkIn < :checkOut) " +
                    ")" +
                    " group by P.id; ", nativeQuery = true)
    List<Producto> getProductsByCityAndDates(@Param("ciudadId")Long city_id, @Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);
}
