package com.loja.utilidades.repositories;

import com.loja.utilidades.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
