package com.donutstore.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@Column(columnDefinition = "CHAR(4)")
	private String idCliente;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String nomeCliente;
	
	@Column(columnDefinition = "VARCHAR(12)")
	private String telefoneCliente;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String rua;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String logradouro;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String bairro;
	
	@Column(columnDefinition = "CHAR(2)")
	private String numero;
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String cidade;
	
	@Column(columnDefinition = "CHAR(2)")
	private String estado;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
