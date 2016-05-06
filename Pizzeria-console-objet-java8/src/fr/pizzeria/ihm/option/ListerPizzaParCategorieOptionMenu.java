package fr.pizzeria.ihm.option;

import java.util.Comparator;
import java.util.stream.Collectors;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaParCategorieOptionMenu extends OptionMenu{
	private static final String LISTER_LES_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU = "Lister les pizzas par catégorie";
	
	private PizzaDao pizzaDao;
	
	public ListerPizzaParCategorieOptionMenu(PizzaDao pizzaDao){
		super(LISTER_LES_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		pizzaDao.afficherToutesPizzas().stream()
			.collect(Collectors.groupingBy(Pizza::getCategorie))
			.forEach((categorie, listePizzas) -> {
				System.out.println(categorie.getValue());
				listePizzas.stream()
					.sorted(Comparator.comparing(Pizza::getCode))
					.forEach(System.out::println);
			});
		return true;
	}

}
