package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements PizzaDao {
	private Pizza[] pizzas = new Pizza[100];
	
	public PizzaDaoImpl() {
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REI", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L’orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L’indienne", 14.00);
	}
	
	@Override
	public Pizza[] afficherToutesPizzas() {
		Pizza[] resultat = new Pizza[100];
		System.arraycopy(pizzas, 0, resultat, 0, resultat.length);
		return resultat;
	}

	@Override
	public boolean nouvellePizza(Pizza nvPizza) {
		boolean placeTrouvee = false;
		int i = 0;
		
		while(!placeTrouvee && i < pizzas.length){
			if (pizzas[i] == null){
				placeTrouvee = true;
			}
			i++;
		}
		
		if (placeTrouvee){
			pizzas[i-1] = nvPizza;
		}
		
		return placeTrouvee;
	}

	@Override
	public boolean modifierPizza(String codePizza, Pizza modPizza) {
		boolean placeTrouvee = false;
		int i = 0;
		
		while(!placeTrouvee && !pizzas[i].equals(null)){
			if (pizzas[i].getCode().equals(codePizza)){
				placeTrouvee = true;
			}
			i++;
		}
		
		if (placeTrouvee){
			pizzas[i - 1] = modPizza;
		}
		
		return placeTrouvee;
	}

	@Override
	public boolean supprimerPizza(String codePizza) {
		boolean placeTrouvee = false;
		int i = 0;

		while (!placeTrouvee && !pizzas[i].equals(null)) {
			if (pizzas[i].getCode().equals(codePizza)){
				placeTrouvee = true;
			}
			i++;
		}

		if (placeTrouvee) {
			pizzas[i - 1] = null;
		}

		return placeTrouvee;
	}

}
