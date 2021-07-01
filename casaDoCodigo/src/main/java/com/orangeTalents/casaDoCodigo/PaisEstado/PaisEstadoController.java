package com.orangeTalents.casaDoCodigo.PaisEstado;

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
@RequestMapping("/endereco")
public class PaisEstadoController {

	@Autowired
	private EstadoRepository repository;
	
	
	//Utilizando repositório
	@PostMapping(value="/estado")
	@Transactional	
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoDto estadoDto) {
		Estado estado = estadoDto.toModel(manager);
		
		if (repository.findByNomeAndPaisId(estadoDto.getNome(), estadoDto.getIdPais()).isPresent()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um estado com este nome cadastrado");
		
		} else return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(estado));
	}
	
	//Utilizando EntityManager
	@PersistenceContext
	private EntityManager manager;
	/*
	@PostMapping(value="/estado")
	@Transactional
	public String cadastrar (@RequestBody @Valid EstadoDto estadoDto) {
		Estado estado = estadoDto.toModel(manager);
		manager.persist(estado);
		return estado.toString();
	}*/
	
	@PostMapping(value="/pais")
	@Transactional
	public String cadastrar (@RequestBody @Valid PaisDto paisDto) {
		Pais pais = paisDto.toModel();
		manager.persist(pais);
		return pais.toString();
	}
	
}
