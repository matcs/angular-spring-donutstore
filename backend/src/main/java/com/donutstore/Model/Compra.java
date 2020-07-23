package com.donutstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompra;
	
	@ManyToOne
	private Cliente idCliente;

	public Compra() {
		super();
	}

	public Compra(long idCompra, Cliente idCliente) {
		super();
		this.idCompra = idCompra;
		this.idCliente = idCliente;
	}

	public Compra(Cliente idCliente){
		this.idCliente = idCliente;
	}
	
	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
