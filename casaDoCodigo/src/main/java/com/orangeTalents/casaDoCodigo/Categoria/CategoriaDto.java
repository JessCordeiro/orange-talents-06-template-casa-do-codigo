package com.orangeTalents.casaDoCodigo.Categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;



public class CategoriaDto {
	
	@NotBlank
	private String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	
	
	public String getNome() {
		return nome;
	}


	public  Categoria toModel() {
		return new Categoria(this.nome);
	}
	
	
	
	
	
}
