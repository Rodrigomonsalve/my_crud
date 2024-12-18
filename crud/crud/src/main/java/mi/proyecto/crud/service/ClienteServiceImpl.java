package mi.proyecto.crud.service;

import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;
import mi.proyecto.crud.repository.ClienteDAO;
import mi.proyecto.crud.repository.DomicilioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final ClienteDAO clienteDAO;
    private final DomicilioDAO domicilioDAO;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO, DomicilioDAO domicilioDAO){
        this.clienteDAO=clienteDAO;
        this.domicilioDAO=domicilioDAO;
    }

    @Override
    public List<Clientes> listClients() {
        return clienteDAO.findAll();
    }


    @Override
    public List<Clientes> findClientByName(String name) {

        return clienteDAO.findByNombre(name);

    }

    @Override
    public List<Clientes> findClientByLastName(String apellido) {

        return clienteDAO.findByApellido(apellido);

    }


    @Override
    public Clientes updateClient(int id) {
        Optional<Clientes> clientesOptional=clienteDAO.findById(id);

            return clientesOptional.get();

        }


    @Override
    public void addClient(Clientes cliente) {
        clienteDAO.save(cliente);

    }

    @Override
    public void deleteClient(int id) {
        Optional<Clientes> clienteOptional=clienteDAO.findById(id);
        if(clienteOptional.isPresent()){
            Clientes clienteExistente=clienteOptional.get();
            clienteDAO.delete(clienteExistente);
        }


    }



}
