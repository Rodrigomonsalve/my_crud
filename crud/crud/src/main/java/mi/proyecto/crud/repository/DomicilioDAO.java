package mi.proyecto.crud.repository;

import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioDAO extends JpaRepository<Domicilio,Integer> {

    @Query("SELECT c FROM Clientes c JOIN c.domicilio d WHERE d.id= :domicilioId")
    public List<Clientes> findClientesAsociados(@Param("domicilioId") Long domicilioId);
}
