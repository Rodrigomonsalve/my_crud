package mi.proyecto.crud.controller;

import jakarta.servlet.http.HttpServletRequest;
import mi.proyecto.crud.entity.Clientes;
import mi.proyecto.crud.entity.Domicilio;
import mi.proyecto.crud.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class ClienteController {

    @Autowired
    IClienteService iClienteService;

    @GetMapping("/")
    public ModelAndView bienvenida(){

        return new ModelAndView("bienvenida");
    }

    @GetMapping("/listClients")
    public String listarClientes(Model modelo){

        List<Clientes> listaDeClientes=iClienteService.listClients();
        modelo.addAttribute("Clientes", listaDeClientes);
        return "listaClientes";
    }

    @GetMapping("/updateClient")
    public ModelAndView modificarCliente(Model modelo, HttpServletRequest request){

        String clientId=request.getParameter("clientId");
        int id=Integer.parseInt(clientId);
        Clientes clienteExistente=iClienteService.updateClient(id);
        clienteExistente.setDomicilio(new ArrayList<>());
        clienteExistente.getDomicilio().add(new Domicilio());
        modelo.addAttribute("cliente", clienteExistente);
        return new ModelAndView("formulario");

    }

    @GetMapping("/muestraFormulario")
    public ModelAndView muestraFormulario(Model modelo){

        Clientes clienteNuevo=new Clientes();
        clienteNuevo.setDomicilio(new ArrayList<>());
        clienteNuevo.getDomicilio().add(new Domicilio());
        modelo.addAttribute("cliente", clienteNuevo);
        return new ModelAndView("formulario");

    }

    @GetMapping("/clientesPorNombre")
    public ModelAndView encontrarClientePorNombre(@RequestParam("name") String name, Model model){

        List<Clientes> clientesExistentes=iClienteService.findClientByName(name);
        model.addAttribute("clientesExistentes", clientesExistentes);
        return new ModelAndView("clientesExistentes");

    }

    @GetMapping("/clientesPorApellido")
    public ModelAndView encontrarClientePorApellido(@RequestParam("lastName") String lastName, Model model){

        List<Clientes> clientesExistentes=iClienteService.findClientByLastName(lastName);
        model.addAttribute("clientesExistentes", clientesExistentes);
        return new ModelAndView("clientesExistentes");

    }

    @PostMapping("/agregarCliente")
    public ModelAndView agregarCliente(@ModelAttribute Clientes cliente){

        iClienteService.addClient(cliente);
        return new ModelAndView("exitoAgregado");
    }

    @GetMapping("/eliminarCliente")
    public ModelAndView eliminarCliente(HttpServletRequest request){

        String clienteId=request.getParameter("cienteId");
        int clienteIdInt = Integer.parseInt(clienteId);
        iClienteService.deleteClient(clienteIdInt);

        return new ModelAndView("exitoBorrado");
    }



}
