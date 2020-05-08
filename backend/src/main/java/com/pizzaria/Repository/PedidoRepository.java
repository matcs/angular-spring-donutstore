package com.pizzaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzaria.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	Pedido findByIdPedido(long pedido);
}
