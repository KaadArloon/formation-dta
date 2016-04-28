package fr.pizzeria.ihm.option;

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
		Pizza[] pizzas = pizzaDao.afficherToutesPizzas();
		for (Pizza p : pizzas) {
			if (p != null) {
				System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "�)");
			}
		}
		return true;
	}
}