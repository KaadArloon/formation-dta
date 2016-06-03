package fr.pizzeria.dao.pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.repository.IPizzaRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Transactional
public class PizzaDaoDataJPA implements IPizzaDao{
	
	@Autowired IPizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		return pizzaRepository.findAll();
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) throws DaoException {
		pizzaRepository.save(nvPizza);		
	}

	@Override
	public void modifierPizza(String codePizza, Pizza modPizza) throws DaoException {
		pizzaRepository.save(modPizza);
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		pizzaRepository.deleteByCode(codePizza);
	}

	@Override
	public void importPizza() throws DaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		return pizzaRepository.findByCode(codePizza);
	}

	@Override
	public void ajoutPizzaLot(List<Pizza> listePizzas, int tailleLot) {
		// TODO Auto-generated method stub
	}
	
}
