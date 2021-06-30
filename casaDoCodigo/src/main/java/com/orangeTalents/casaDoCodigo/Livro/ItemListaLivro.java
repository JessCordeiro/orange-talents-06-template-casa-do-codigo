package com.orangeTalents.casaDoCodigo.Livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ItemListaLivro {

	@Autowired
	private LivroRepository repository;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Livro>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
}
