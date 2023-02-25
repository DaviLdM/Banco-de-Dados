package com.produtos.apirest.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




public class Contabil {

	private static final long seriaLVersionUID = 1L;
	
	@Id 
	
	
	
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String cpfcnpj;
	
	
	

	

	private List<LivroCaixaContabil> contabeis ;
	
	
	
	
	public List<LivroCaixaContabil> getContabeis() {
		return contabeis;
	}

	public void setContabeis(List<LivroCaixaContabil> contabeis) {
		this.contabeis = contabeis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
