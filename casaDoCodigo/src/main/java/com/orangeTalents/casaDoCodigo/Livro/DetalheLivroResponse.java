package com.orangeTalents.casaDoCodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.orangeTalents.casaDoCodigo.Autor.Autor;

public class DetalheLivroResponse {
	
	private DetalheLivroResponse autor;
	private String titulo;
	private String isbn;
	private Integer paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private LocalDate dataPublicacao;
	
	private String nome;
	private String descricao;
	
	public  DetalheLivroResponse(Autor autor) {
		
		nome = autor.getNome();
		descricao = autor.getDescricao();
		
	}
	
	

	public DetalheLivroResponse(Livro livro) {
		
		titulo = livro.getTitulo();
		resumo = livro.getResumo();
		isbn = livro.getIsbn();
		paginas = livro.getPaginas();
		preco = livro.getPreco();
		sumario = livro.getSumario();
		dataPublicacao = livro.getDataPublicacao();
		
	}



	



	public DetalheLivroResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumeroPaginas() {
		return paginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

	
}
