package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	IPizzaDao DEFAULT_IMPLEMENTATION = new PizzaDaoImpl();

	List<Pizza> afficherToutesPizzas() throws DaoException;
	void nouvellePizza(Pizza nvPizza) throws DaoException;
	void modifierPizza(String codePizza, Pizza modPizza) throws DaoException;
	void supprimerPizza(String codePizza) throws DaoException;
	void importPizza() throws DaoException;
	Pizza trouverPizza(String codePizza);
	void ajoutPizzaLot(List<Pizza> listePizzas, int tailleLot);
}
