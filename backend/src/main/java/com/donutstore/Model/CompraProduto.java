package com.donutstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class CompraProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompraProduto;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Cliente idCliente;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Compra idCompra;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Donut idDonut;

	public CompraProduto() { 
		super();
	}

	public CompraProduto(Cliente idCliente,Donut idDonut ,Compra idCompra) {
		this.idCliente = idCliente;
		this.idDonut = idDonut;
		this.idCompra = idCompra;
	}
	
	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdCompraProduto() {
		return idCompraProduto;
	}

	public void setIdCompraProduto(long idCompraProduto) {
		this.idCompraProduto = idCompraProduto;
	}

	public Compra getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Compra idCompra) {
		this.idCompra = idCompra;
	}

	public Donut getIdDonut() {
		return idDonut;
	}

	public void setIdDonut(Donut idDonut) {
		this.idDonut = idDonut;
	}
	
}
