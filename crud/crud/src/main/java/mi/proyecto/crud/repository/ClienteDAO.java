package mi.proyecto.crud.repository;

import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteDAO extends JpaRepository<Clientes, Integer> {

    public List<Clientes> findByNombre(String name);
    public List<Clientes> findByApellido(String apellido);
    public Domicilio findByDomicilio(Domicilio domicilio);
}