package com.orangeTalents.casaDoCodigo.PaisEstado;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.orangeTalents.casaDoCodigo.Livro.Livro;
import com.orangeTalents.casaDoCodigo.Validacao.UniqueValue;

public class PaisDto {

	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String nome;

	public String getNome() {
		return nome;
	}
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}

}