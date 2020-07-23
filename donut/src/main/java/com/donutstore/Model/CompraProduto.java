package com.donutstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CompraProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompraProduto;
	
	@ManyToOne
	private Compra idCompra;
	
	@ManyToOne
	private Cliente IdCliente;
	
	@OneToOne
	private Donut idDonut;

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

	public Donut getIdProduto() {
		return idDonut;
	}

	public void setIdProduto(Donut idDonut) {
		this.idDonut = idDonut;
	}
	
}
