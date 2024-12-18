package mi.proyecto.crud.service;

import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;

import java.util.List;

public interface IDomicilioService {

    public void addAddress(Clientes cliente, Domicilio domicilio);
    public List<Domicilio> listDomicilios(Clientes cliente);
    public void deleteAddress(Domicilio domicilio);
}
