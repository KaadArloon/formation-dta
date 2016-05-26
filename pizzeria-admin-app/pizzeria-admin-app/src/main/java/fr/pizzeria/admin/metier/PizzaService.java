package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	private IPizzaDao pizzadao;

	public List<Pizza> afficherToutesPizzas(){
		try {
			return pizzadao.afficherToutesPizzas();
		} catch (DaoException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public void nouvellePizza(Pizza nvPizza){
		try {
			pizzadao.nouvellePizza(nvPizza);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierPizza(String codePizza, Pizza modPizza){
		try {
			pizzadao.modifierPizza(codePizza, modPizza);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public void supprimerPizza(String codePizza){
		try {
			pizzadao.supprimerPizza(codePizza);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public void importPizza(){
		try {
			pizzadao.importPizza();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public Pizza trouverPizza(String codePizza){
		return pizzadao.trouverPizza(codePizza);
	}
}
