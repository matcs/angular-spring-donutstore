package com.pizzaria.Repository;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.Model.Cliente;
import com.pizzaria.Model.Pedido;
import com.pizzaria.Model.Sabor;

public interface PedidoRepository extends CrudRepository<Pedido, String>{
	Pedido findByIdPedido(long pedido);
}
