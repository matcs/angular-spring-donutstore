package com.pizzaria.Repository;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.Model.Cliente;

public interface ClienteRepositoy extends CrudRepository<Cliente, String> {
	Cliente findByIdCliente(long idCliente);
}
