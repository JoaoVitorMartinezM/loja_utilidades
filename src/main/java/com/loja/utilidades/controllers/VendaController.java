package com.loja.utilidades.controllers;


import com.loja.utilidades.models.Venda;
import com.loja.utilidades.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/vendas", name = "Module Venda")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping(value = "/")
    public List<Venda> get(){
        return service.get();
    }

    @GetMapping(value = "/id{id}", name = "GetById")
    public Venda getById(@RequestParam Integer id){
        return service.getById(id);
    }

    @DeleteMapping(value = "/delete/id{id}", name = "Delete")
    public Boolean delete(@RequestParam Integer id){
        return service.delete(id);

    }

    @PutMapping(value = "/edit/id{id}", name = "Edit")
    public Venda edit(@RequestParam Integer id, @RequestBody Venda venda){
        return service.edit(venda, id);

    }


    @PostMapping(value = "/novo", name = "Save")
    public Venda save(@RequestBody Venda venda){
        return service.save(venda);
    }



}
