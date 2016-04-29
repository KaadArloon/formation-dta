package fr.pizzeria.ihm.option;

import java.util.List;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class AfficherPizzaOptionMenu extends OptionMenu {

	private static final String LISTER_LES_PIZZAS_LIBELLE_MENU = "Lister les pizzas";

	private PizzaDao pizzaDao;

	public AfficherPizzaOptionMenu(PizzaDao pizzaDao) {
		super(LISTER_LES_PIZZAS_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		System.out.println("Lister les pizzas Menu");
		List<Pizza> pizzas = pizzaDao.afficherToutesPizzas();
		for (Pizza p : pizzas) {
			System.out.println(p.toString());
		}
		return true;
	}
}
