package com.pizzaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.Model.Cliente;

public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {
	Cliente findByIdCliente(long idCliente);
}
