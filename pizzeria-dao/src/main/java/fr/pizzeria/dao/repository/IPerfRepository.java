package fr.pizzeria.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;

public interface IPerfRepository extends JpaRepository<Performance, Integer>{
	
}
