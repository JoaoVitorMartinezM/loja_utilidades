package com.loja.utilidades.controllers;

import com.loja.utilidades.models.Produto;
import com.loja.utilidades.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto" , name = "Modulo Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/", name = "Get")
    public List<Produto> get(){
        return service.get();
    }

    @GetMapping(value = "/id{id}", name = "GetById")
    public  Produto getById(@RequestParam Integer id){
        return service.getById(id);
    }

    @PutMapping(value = "/edit/id{id}", name = "Edit")
    public  Produto edit(@RequestParam Integer id, @RequestBody Produto produto){
        return service.edit(id, produto);
    }

    @PostMapping(value = "/novo", name = "Novo produto")
    public Produto save(@RequestBody Produto produto){
        return service.save(produto);
    }

    @DeleteMapping(value = "/deleta/id{id}", name = "Delete")
    public Boolean delete(@RequestParam Integer id){
        return service.delete(id);
    }

}
