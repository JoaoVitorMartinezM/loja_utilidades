package com.loja.utilidades.controllers;


import com.loja.utilidades.models.Venda;
import com.loja.utilidades.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
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

    @GetMapping(value = "/search{dataInicio}{dataFinal}", name = "GetByDate")
    public List<Venda> getByDate(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicio,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datafinal
    ){
        return service.getByDate(dataInicio, datafinal);
    }

    @GetMapping(value = "/search{status}", name = "GetByStatus")
    public Venda getByStatus(@RequestParam String status){
        return service.getByStatus(status);
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

    @PutMapping(value = "/cancel/id{id}", name = "Edit")
    public Boolean cancel(@RequestParam Integer id){
        return service.cancel(id);

    }



}
