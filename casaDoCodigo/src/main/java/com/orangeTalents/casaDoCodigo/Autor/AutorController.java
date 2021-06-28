package com.orangeTalents.casaDoCodigo.Autor;



import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/autores")
public class AutorController {
	
	
	
	@Autowired
	private AutorRepository repository;
	
	
	
	@PostMapping
	@Transactional	
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorDto autorDto) {
		Autor autor = autorDto.toModel();
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(autor));
	}
	
	

}
