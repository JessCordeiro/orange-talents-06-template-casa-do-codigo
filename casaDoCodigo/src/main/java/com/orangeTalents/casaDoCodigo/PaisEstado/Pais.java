package com.orangeTalents.casaDoCodigo.PaisEstado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique=true)
	private String nome;
	
	
	
	@Deprecated
	public Pais() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	public Pais(String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
}
