package com.orangeTalents.casaDoCodigo.Autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.InitBinder;



public class AutorDto {
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(max=400)
	private String descricao;
	@NotNull
	private LocalDateTime dataCriacao= LocalDateTime.now();

	public AutorDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max=400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}

	


	public String getNome() {
		return nome;
	}



	public String getDescricao() {
		return descricao;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public  Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return this.email;
	}
	
	
}
