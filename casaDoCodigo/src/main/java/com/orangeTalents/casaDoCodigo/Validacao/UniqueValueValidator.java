package com.orangeTalents.casaDoCodigo.Validacao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;




public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

	@PersistenceContext
	EntityManager manager;
	private String domainAttribute;
	private Class<?> klass;
	

	
	 @Override
	    public void initialize(UniqueValue uniqueValue) {
	    domainAttribute = uniqueValue.fieldName().toLowerCase();
	    klass = uniqueValue.domainClass();
	    }
	    
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM "+klass.getName()+ "WHERE" +domainAttribute+"=:VALUE");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1,"foi encontrado valor igual");
		return list.isEmpty();
	
	}
	
}



	