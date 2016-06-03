package fr.pizzeria.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, Integer>{
	Pizza findByCode(String code);
	
	@Transactional
	void deleteByCode(String code);
}
