package com.loja.utilidades.repositories;

import com.loja.utilidades.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepo extends JpaRepository<Venda, Integer> {
}
