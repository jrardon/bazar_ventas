package com.ventas.bazar.controller;

import ch.qos.logback.core.net.server.Client;
import com.ventas.bazar.model.Cliente;
import com.ventas.bazar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteServ;

    @PostMapping ("/clientes/crear")
    public void registrarCliente(@RequestBody Cliente cli){
        clienteServ.guardarCliente(cli);
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteServ.listarClientes();
    }

    @GetMapping ("/clientes/{id_cliente}")
    public Cliente buscarCliente(@PathVariable Long id_cliente){
        return clienteServ.buscarCliente(id_cliente);
    }

    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente){
        clienteServ.eliminarCliente(id_cliente);
    }

    @PutMapping ("/clientes/editar/{id_cliente}")
    public Cliente editarCliente(@RequestBody Cliente cli){
        clienteServ.actualizarCliente(cli);
        return clienteServ.buscarCliente(cli.getId_cliente());
    }

}
