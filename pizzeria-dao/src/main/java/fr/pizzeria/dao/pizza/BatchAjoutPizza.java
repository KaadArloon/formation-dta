package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class BatchAjoutPizza{
	
	@PersistenceContext private EntityManager em;

	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void ajoutPizza(List<Pizza> p){
		p.forEach(em::persist);
	}
}
