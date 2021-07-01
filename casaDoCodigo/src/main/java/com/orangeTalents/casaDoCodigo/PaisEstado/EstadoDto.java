package com.orangeTalents.casaDoCodigo.PaisEstado;

import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.orangeTalents.casaDoCodigo.Livro.Livro;
import com.orangeTalents.casaDoCodigo.Validacao.UniqueValue;

public class EstadoDto {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String nome;
	
	@OneToOne
	@NotNull
	 private Long idPais;
	
	@Deprecated
	public EstadoDto() {
		
	}

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public EstadoDto(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public Estado toModel(EntityManager em) {
		
		@NotNull Pais pais = em.find(Pais.class, this.idPais);
		
		return new Estado(this.nome, pais);
	}
	
	
	
}
