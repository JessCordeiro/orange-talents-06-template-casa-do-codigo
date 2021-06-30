package com.orangeTalents.casaDoCodigo.Livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/detalhes")
public class DetalheLivro {

	@Autowired
	private LivroRepository repository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroResponse> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = repository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalheLivroResponse(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
}
