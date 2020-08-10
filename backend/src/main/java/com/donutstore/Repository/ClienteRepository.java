package com.donutstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donutstore.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByIdCliente(Long idCliente);
	Cliente findByEmail(String email);
}
