package com.loja.utilidades.services;


import com.loja.utilidades.models.Cliente;
import com.loja.utilidades.models.Produto;
import com.loja.utilidades.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo repositorio;

    public List<Cliente> get() {
        return repositorio.findAll();
    }

    public Cliente getById(Integer id) {
        return repositorio.findById(id).get();
    }

    public Cliente edit(Integer id, Cliente cliente) {
        if (repositorio.existsById(id)){
            Cliente clienteEditado = repositorio.findById(id).get();
            clienteEditado.setAtivo(cliente.getAtivo());
            clienteEditado.setCpfCnpj(cliente.getCpfCnpj());
            clienteEditado.setNome(cliente.getNome());
            return repositorio.save(clienteEditado);
        }
        return null;
    }

    public Boolean delete(Integer id) {
        if (repositorio.existsById(id)){
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }
}
