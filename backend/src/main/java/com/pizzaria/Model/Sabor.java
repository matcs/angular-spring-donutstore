package com.pizzaria.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sabor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSabor;
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String nomeSabor;
	
	private float preco;
	
	public long getIdSabor() {
		return idSabor;
	}

	public void setIdSabor(long idSabor) {
		this.idSabor = idSabor;
	}

	public String getNomeSabor() {
		return nomeSabor;
	}

	public void setNomeSabor(String nomeSabor) {
		this.nomeSabor = nomeSabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
