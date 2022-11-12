package com.loja.utilidades.services;

import com.loja.utilidades.models.Produto;
import com.loja.utilidades.repositories.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepo repositorio;

    public List<Produto> get() {
        return repositorio.findAll();
    }

    public Produto getById(Integer id) {
        return repositorio.findById(id).get();

    }

    public Produto edit(Integer id, Produto produto) {
        if (repositorio.existsById(id)){
            Produto produtoEditado = repositorio.findById(id).get();
            produtoEditado.setAtivo(produto.getAtivo());
            produtoEditado.setDescricao(produto.getDescricao());
            produtoEditado.setNome(produto.getNome());
            produtoEditado.setSku(produto.getSku());

            return repositorio.save(produtoEditado);
        }

        return null;
    }

    public Produto save(Produto produto) {
        return repositorio.save(produto);
    }

    public Boolean delete(Integer id) {
        if (repositorio.existsById(id)){
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
