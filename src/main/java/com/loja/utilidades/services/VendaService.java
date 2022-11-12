package com.loja.utilidades.services;

import com.loja.utilidades.models.Venda;
import com.loja.utilidades.repositories.VendaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepo repositorio;

    public List<Venda> get() {
        return repositorio.findAll();
    }

    public Venda getById(Integer id){
        return repositorio.findById(id).get();

    }

    public Venda save(Venda venda){
        return repositorio.save(venda);
    }

    public Venda edit(Venda venda, Integer id){
        if (repositorio.existsById(id)){

            Venda vendaEditada = repositorio.findById(id).get();
            vendaEditada.setCliente(venda.getCliente());
            vendaEditada.setData(venda.getData());
//            vendaEditada.setProdutos(venda.getProdutos());
            vendaEditada.setQuantidade(venda.getQuantidade());
            vendaEditada.setStatus(venda.getStatus());
            vendaEditada.setValor(venda.getValor());

            return repositorio.save(vendaEditada);

        }
        return null;
    }

    public Boolean delete(Integer id){
        if (repositorio.existsById(id)){
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }






}
