package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	Pizza[] afficherToutesPizzas();
	void nouvellePizza(Pizza nvPizza) throws SavePizzaException;
	void modifierPizza(String codePizza, Pizza modPizza) throws UpdatePizzaException;
	void supprimerPizza(String codePizza) throws DeletePizzaException;
}
