package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	List<Pizza> afficherToutesPizzas()  throws DaoException;

	void nouvellePizza(Pizza nvPizza) throws DaoException;

	void modifierPizza(String codePizza, Pizza modPizza) throws DaoException;

	void supprimerPizza(String codePizza) throws DaoException;
}