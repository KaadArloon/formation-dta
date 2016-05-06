package fr.pizzeria.ihm.option;

import java.util.Comparator;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class AfficherPizzaPlusCherOptionMenu extends OptionMenu {

	private static final String LISTER_LA_PIZZAS_LA_PLUS_CHERE_LIBELLE_MENU = "Lister la pizza la plus chère";

	private PizzaDao pizzaDao;

	public AfficherPizzaPlusCherOptionMenu(PizzaDao pizzaDao) {
		super(LISTER_LA_PIZZAS_LA_PLUS_CHERE_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		Comparator<Pizza> compPrix = Comparator.comparing(Pizza::getPrix);
		System.out.println(pizzaDao.afficherToutesPizzas().stream().max(compPrix).get().toString());
		return true;
	}
}
