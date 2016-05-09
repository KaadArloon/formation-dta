package fr.pizzeria.ihm.option;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DaoException;

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
		try {
			pizzaDao.afficherToutesPizzas().forEach(System.out::println);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
