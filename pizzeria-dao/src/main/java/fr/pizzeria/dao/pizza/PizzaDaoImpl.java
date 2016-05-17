package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaDaoImpl implements IPizzaDao {
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	
	public PizzaDaoImpl() {
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE, ""));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE, ""));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE, ""));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE, ""));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE, ""));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE, ""));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE, ""));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE, ""));
	}

	@Override
	public List<Pizza> afficherToutesPizzas() {
		return new ArrayList<Pizza>(pizzas.values());
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) throws SavePizzaException {
		if(pizzas.containsKey(nvPizza.getCode())) {
			throw new SavePizzaException("code pizza d�j� pr�sent");
		}
		pizzas.put(nvPizza.getCode(), nvPizza);
	}

	@Override
	public void modifierPizza(String codePizza, Pizza modPizza) throws UpdatePizzaException {
		if(!pizzas.containsKey(codePizza)) {
			throw new UpdatePizzaException("code pizza non trouv�");
		}
		pizzas.put(codePizza, modPizza);
	}

	@Override
	public void supprimerPizza(String codePizza) throws DeletePizzaException {
		if(!pizzas.containsKey(codePizza)) {
			throw new DeletePizzaException("code pizza non trouv�");
		}
		pizzas.remove(codePizza);
	}
}
