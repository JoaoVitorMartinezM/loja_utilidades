package com.loja.utilidades.repositories;

import com.loja.utilidades.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VendaRepo extends JpaRepository<Venda, Integer> {


    List<Venda> findByDataBetween(Date dataInicio, Date datafinal);

    Venda findByStatus(String status);
}
