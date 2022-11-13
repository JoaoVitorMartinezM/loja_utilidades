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
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Venda venda  = repositorio.findById(id).get();
        return venda;

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

    public Venda edit(Venda venda, Integer id){
        if (repositorio.existsById(id)){

            Double vendaValorTotal = 0.0;
            Double vendaQuantidade = 0.0;
            Venda vendaEditada = repositorio.findById(id).get();
            Cliente cliente = clienteRepo.findById(1).get();
            List<VendaItem> listaItens = new ArrayList<>();

            for (VendaItem item: venda.getProdutos()) {
                item.setVenda(venda);
                Produto produto = produtoRepo.findById(item.getProduto().getId()).get();
                item.setProduto(produto);
                item.setValorUnitario(produto.getValorUnitario());
                item.setValorTotal(produto.getValorUnitario() * item.getQuantidade());

                vendaValorTotal = item.getValorTotal();
                vendaQuantidade = item.getQuantidade();
                listaItens.add(item);

            }


            vendaEditada.setProdutos(listaItens);
            vendaEditada.setQuantidade(vendaQuantidade);
            vendaEditada.setValor(vendaValorTotal);
            vendaEditada.setCliente(cliente);




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


    public Boolean cancel(Integer id) {
        if (repositorio.existsById(id)){
            Venda vendaCancelada = repositorio.findById(id).get();
            vendaCancelada.setStatus("C");
            repositorio.save(vendaCancelada);
            return true;
        }
        return false;
    }

    public List<Venda> getByDate(Date dataInicio, Date datafinal) {

        if (datafinal == null || dataInicio == null) {

            return new ArrayList<>();
        }
        return repositorio.findByDataBetween(dataInicio, datafinal);
    }

    public Venda getByStatus(String status) {
        if (status == null || status == ""){
            return null;
        }
        return repositorio.findByStatusIgnoreCase(status);
    }
}
