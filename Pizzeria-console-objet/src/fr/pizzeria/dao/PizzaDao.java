package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	Pizza[] afficherToutesPizzas();
	boolean nouvellePizza(Pizza nvPizza);
	boolean modifierPizza(String codePizza, Pizza modPizza);
	boolean supprimerPizza(String codePizza);
}
