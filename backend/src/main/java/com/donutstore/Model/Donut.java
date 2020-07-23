package com.donutstore.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donut {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDonut;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean status;
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String nomeSabor;
	
	@Column(columnDefinition = "FLOAT")
	private float preco;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] imagem;

	public long getIdDonut() {
		return idDonut;
	}

	public void setIdDonut(long idDonut) {
		this.idDonut = idDonut;
	}

	public long getIdSabor() {
		return idDonut;
	}

	public void setIdSabor(long idDonut) {
		this.idDonut = idDonut;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
}
