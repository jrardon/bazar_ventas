package com.ventas.bazar.service;

import com.ventas.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {
    public void guardarCliente(Cliente cli);
    public void actualizarCliente(Cliente cli);
    public void eliminarCliente(Long id);
    public List<Cliente> listarClientes();
    public Cliente buscarCliente(Long id);

}
