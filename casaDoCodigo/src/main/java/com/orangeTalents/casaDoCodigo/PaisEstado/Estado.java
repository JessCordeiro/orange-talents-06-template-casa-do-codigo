package com.orangeTalents.casaDoCodigo.PaisEstado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(unique=true)
	private String nome;
	
	@Deprecated
	public Estado() {
	
	}
	@ManyToOne
	private Pais pais;
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	

	
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
	
	
	
	
	
}
