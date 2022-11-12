package com.loja.utilidades.controllers;


import com.loja.utilidades.models.Cliente;
import com.loja.utilidades.models.Produto;
import com.loja.utilidades.services.ClienteService;
import com.loja.utilidades.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos", name = "Module Produto")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/", name = "Get")
    public List<Cliente> get(){
        return service.get();
    }

    @GetMapping(value = "/id{id}", name = "GetById")
    public  Cliente getById(@RequestParam Integer id){
        return service.getById(id);
    }

    @PutMapping(value = "/edit/id{id}", name = "Edit")
    public  Cliente edit(@RequestParam Integer id, @RequestBody Cliente cliente){
        return service.edit(id, cliente);
    }

    @DeleteMapping(value = "/delete/id{id}", name = "Delete")
    public Boolean delete(@RequestParam Integer id){
        return service.delete(id);
    }
    @PostMapping(value = "/novo", name = "Save")
    public Cliente save(@RequestBody Cliente cliente){
        return service.save(cliente);
    }


}
