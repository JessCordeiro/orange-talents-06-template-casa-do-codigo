package com.orangeTalents.casaDoCodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orangeTalents.casaDoCodigo.Autor.Autor;
import com.orangeTalents.casaDoCodigo.Categoria.Categoria;

@Entity
public class Livro {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique=true)
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
	 @Column(unique=true)
	 private String isbn;
	 @NotNull
	 @Future
	 @JsonIgnoreProperties(value = {"dataPublicacao"}, ignoreUnknown = true, allowSetters= true)
	 @JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	 private LocalDate dataPublicacao;
	 
	 @Deprecated
	 public Livro() {
		super();
	
		
	}
	 
	@ManyToOne
	private Categoria categoria;
		
	@ManyToOne
	private Autor autor;

	


	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
				@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
				@NotNull @Future LocalDate dataPublicacao, Categoria categoria, Autor autor) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.resumo = resumo;
			this.sumario = sumario;
			this.preco = preco;
			this.paginas = paginas;
			this.isbn = isbn;
			this.dataPublicacao = dataPublicacao;
			this.categoria = categoria;
			this.autor = autor;
		}
	
	

	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", paginas=" + paginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao + "]";
	}
	
	
	 
	 
	 
	
}
