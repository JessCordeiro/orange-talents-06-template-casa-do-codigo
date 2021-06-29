package com.orangeTalents.casaDoCodigo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;
	
	
	@PostMapping
	@Transactional
	public String cadastrar (@RequestBody @Valid CategoriaDto categoriaDto) {
		Categoria categoria = categoriaDto.toModel();
		manager.persist(categoria);
		return categoria.toString();
	}
	
}
