package com.orangeTalents.casaDoCodigo.Autor;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
	
		return AutorDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorDto request = (AutorDto) target;
		Optional<Autor> possivelAutor =  autorRepository.findByEmail(request.getEmail());
		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um outro autor com mesmo email"+ request.getEmail());
		}
	}

}
