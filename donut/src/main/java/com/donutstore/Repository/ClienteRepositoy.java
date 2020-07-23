package com.donutstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donutstore.Model.Cliente;

public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {
	Cliente findByIdCliente(long idCliente);
}
