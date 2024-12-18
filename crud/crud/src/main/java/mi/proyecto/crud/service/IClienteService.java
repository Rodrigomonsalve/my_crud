package mi.proyecto.crud.service;

import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;

import java.util.List;

public interface IClienteService {

    public List<Clientes> listClients();
    public List<Clientes> findClientByName(String name);
    public List<Clientes> findClientByLastName(String apellido);
    public Clientes updateClient(int id);
    public void addClient(Clientes cliente);
    public void deleteClient(int id);



}
