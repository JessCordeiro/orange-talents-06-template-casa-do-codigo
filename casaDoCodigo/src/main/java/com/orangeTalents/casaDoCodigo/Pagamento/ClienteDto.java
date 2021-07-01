package com.orangeTalents.casaDoCodigo.Pagamento;



import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;


import com.orangeTalents.casaDoCodigo.PaisEstado.Estado;
import com.orangeTalents.casaDoCodigo.PaisEstado.Pais;
import com.orangeTalents.casaDoCodigo.Validacao.CPFouCNPJ;
import com.orangeTalents.casaDoCodigo.Validacao.UniqueValue;

/**
 * @author jessica.cordeiro
 *
 */
public class ClienteDto {
	ClienteRepository repository;
	
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CPFouCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Long idPais;
	@NotNull
	@ManyToOne
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	@Deprecated
	public ClienteDto() {
		
	}


	
	
	
	public ClienteDto(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}









	public String getEmail() {
		return email;
	}



	public String getNome() {
		return nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public String getDocumento() {
		return documento;
	}



	public String getEndereco() {
		return endereco;
	}



	public String getComplemento() {
		return complemento;
	}



	public String getCidade() {
		return cidade;
	}



	public Long getIdPais() {
		return idPais;
	}



	public Long getIdEstado() {
		return idEstado;
	}



	public String getTelefone() {
		return telefone;
	}



	public String getCep() {
		return cep;
	}

	

	public  Cliente toModel(EntityManager em) {
		
		@NotNull Pais pais = em.find(Pais.class, this.idPais);
		@NotNull Estado estado = em.find(Estado.class, this.idEstado);
		
		
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
	}
	
	
	
	
}
