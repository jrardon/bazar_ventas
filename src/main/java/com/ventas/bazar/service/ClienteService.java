package com.ventas.bazar.service;

import com.ventas.bazar.model.Cliente;
import com.ventas.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public void guardarCliente(Cliente cli){
        clienteRepository.save(cli);
    }

    @Override
    public void actualizarCliente(Cliente cli) {
        this.guardarCliente(cli);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        Cliente cli = clienteRepository.findById(id).orElse(null);
        return cli;
    }
}
