package com.orangeTalents.casaDoCodigo.Pagamento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@RequestMapping
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClienteRepository repository;
	
	
	
	@PostMapping(value="/cliente")
	@Transactional	
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDto clienteDto) {
		Cliente cliente = clienteDto.toModel(manager);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
	}
	
	
	
}
