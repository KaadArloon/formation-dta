package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu{

	private static final String AJOUTER_UNE_PIZZA_LIBELLE_MENU = "Ajouter une nouvelle pizza";
	
	private PizzaDao pizzaDao;
	private Scanner scanner;

	public NouvellePizzaOptionMenu(PizzaDao pizzaDao, Scanner sc) {
		super(AJOUTER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		scanner = sc;
	}

	@Override
	public boolean execute() {
		System.out.println("Ajout d’une nouvelle pizza");

		System.out.println("Veuillez saisir le code");
		String code = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = scanner.next();
		System.out.println("Veuillez saisir le prix");
		Double prix = scanner.nextDouble();
		
		Pizza nvPizza = new Pizza(code, name, prix);
		if (pizzaDao.nouvellePizza(nvPizza)){
			System.out.println("Nouvelle pizza ajoutée");
		}
		else {
			System.out.println("Erreur lors de l'insertion");
		}

		return true;
	}

}
