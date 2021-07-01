package com.orangeTalents.casaDoCodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.orangeTalents.casaDoCodigo.Autor.Autor;
import com.orangeTalents.casaDoCodigo.Categoria.Categoria;
import com.orangeTalents.casaDoCodigo.Validacao.ExistsId;
import com.orangeTalents.casaDoCodigo.Validacao.UniqueValue;

public class LivroDto {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	 private String titulo;
	@NotBlank
	@Size(max=500)
	 private String resumo;
	
	 private String sumario;
	 
	 @NotNull
	 @Min(20)
	 private BigDecimal preco;
	 
	 @NotNull
	 @Min(100)
	 private Integer paginas;
	 
	 @NotBlank
	 @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	 private String isbn;
	 
	 @NotNull
	 @Future
	 @JsonIgnoreProperties(value = {"dataPublicacao"}, ignoreUnknown = true, allowSetters= true)
	 @JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	 private LocalDate dataPublicacao;
	 
	 @ManyToOne
	 @NotNull
	 @ExistsId(domainClass = Autor.class, fieldName = "id")
	 private Long idAutor;
	 
	 @ManyToOne
	 @NotNull
	 @ExistsId(domainClass = Categoria.class, fieldName = "categoria")
	 private Long idCategoria;

	 @Deprecated
	public LivroDto() {
		super();
		
	}

	public LivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	

	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	
	
	
	 public Livro toModel(EntityManager em) {
	
		@NotNull Categoria categoria = em.find(Categoria.class, this.idCategoria);
		@NotNull Autor autor = em.find(Autor.class, this.idAutor);
		
		
		 
		 return new Livro(this.titulo, this.resumo, this.sumario,this.preco, this.paginas, this.isbn, this.dataPublicacao, categoria, autor);
	 }

	

	

	

	
	 
	 
	
}
