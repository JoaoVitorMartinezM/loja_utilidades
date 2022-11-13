package com.loja.utilidades.services;

import com.loja.utilidades.models.Cliente;
import com.loja.utilidades.models.Produto;
import com.loja.utilidades.models.Venda;
import com.loja.utilidades.models.VendaItem;
import com.loja.utilidades.repositories.ClienteRepo;
import com.loja.utilidades.repositories.ProdutoRepo;
import com.loja.utilidades.repositories.VendaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepo repositorio;

    @Autowired
    private ProdutoRepo produtoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    public List<Venda> get() {
        return repositorio.findAll();
    }

    public Venda getById(Integer id){
        return repositorio.findById(id).get();

    }

    public Venda save(Venda venda){

        Double vendaTotal = 0.0;
        Double vendaQuantidade = 0.0;
        for (VendaItem item : venda.getProdutos()){
            item.setVenda(venda);
            Produto produto = produtoRepo.findById(item.getProduto().getId()).get();
            item.setProduto(produto);
            item.setValorUnitario(produto.getValorUnitario());
            item.setValorTotal(item.getValorUnitario() * item.getQuantidade());

            vendaTotal = item.getValorTotal();
            vendaQuantidade = item.getQuantidade();
        }
        venda.setQuantidade(vendaQuantidade);
        venda.setValor(vendaTotal);
        venda.setStatus("P");
        return repositorio.save(venda);
    }

//    public Venda edit(Venda venda, Integer id){
//        if (repositorio.existsById(id)){
//
//            Double vendaValorTotal = 0.0;
//            Double vendaQuantidade = 0.0;
//            Venda vendaEditada = repositorio.findById(id).get();
//            Cliente cliente = clienteRepo.findById(1).get();
//            List<VendaItem> listaItens = new ArrayList<>();
//
//            for (VendaItem item: venda.getProdutos()) {
//                item.setVenda(venda);
//                Produto produto = produtoRepo.findById(item.getProduto().getId()).get();
//                item.setProduto(produto);
//                item.setValorUnitario(produto.getValorUnitario());
//                item.setValorTotal(produto.getValorUnitario() * item.getQuantidade());
//
//                vendaValorTotal = item.getValorTotal();
//                vendaQuantidade = item.getQuantidade();
//                listaItens.add(item);
//
//            }
//
//
//            vendaEditada.setProdutos(listaItens);
//            vendaEditada.setQuantidade(vendaQuantidade);
//            vendaEditada.setValor(vendaValorTotal);
//            vendaEditada.setCliente(cliente);
//
//
//
//
//            return repositorio.save(vendaEditada);
//
//        }
//        return null;
//    }

    public Boolean delete(Integer id){
        if (repositorio.existsById(id)){
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }






}
