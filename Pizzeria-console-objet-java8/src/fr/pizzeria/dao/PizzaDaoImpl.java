package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements PizzaDao {
	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> afficherToutesPizzas() {
		List<Pizza> resultat = new ArrayList<Pizza>();
		pizzas.stream().forEach(p -> resultat.add(p));
		return resultat;
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) throws SavePizzaException {
		if (!pizzas.add(nvPizza)) {
			throw new SavePizzaException();
		}
	}

	@Override
	public void modifierPizza(String codePizza, Pizza modPizza) throws UpdatePizzaException {
		boolean placeTrouvee = false;
		
		/*pizzas.stream().forEach(p -> {
			if (p.getCode().equals(codePizza)) {
				p.setCode(modPizza.getCode());
				p.setId(modPizza.getId());
				p.setNom(modPizza.getNom());
				p.setPrix(modPizza.getPrix());
				placeTrouvee = true;
			}
		});*/
		for (Pizza p : pizzas) {
			if (p.getCode().equals(codePizza)) {
				p.setCode(modPizza.getCode());
				p.setId(modPizza.getId());
				p.setNom(modPizza.getNom());
				p.setPrix(modPizza.getPrix());
				placeTrouvee = true;
			}
		}

		if (!placeTrouvee) {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void supprimerPizza(String codePizza) throws DeletePizzaException {
		boolean placeTrouvee = false;

		Iterator<Pizza> itPizzas = pizzas.iterator();
		while (itPizzas.hasNext()) {
			Pizza p = itPizzas.next();
			if (p.getCode().equals(codePizza)) {
				itPizzas.remove();
				placeTrouvee = true;
			}
		}

		if (!placeTrouvee) {
			throw new DeletePizzaException();
		}
	}

}
