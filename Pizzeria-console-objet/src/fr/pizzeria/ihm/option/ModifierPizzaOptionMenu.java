package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	private static final String MODIFIER_UNE_PIZZA_LIBELLE_MENU = "Mettre à jour une pizza";
	
	private PizzaDao pizzaDao;
	private Scanner scanner;

	public ModifierPizzaOptionMenu(PizzaDao pizzaDao, Scanner sc) {
		super(MODIFIER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		scanner = sc;
	}

	@Override
	public boolean execute() {
		new AfficherPizzaOptionMenu(pizzaDao).execute();

		System.out.println("Veuillez choisir le code de la pizza à modifier.\n(99 pour abandonner).");
		String choix = scanner.next();

		if (!choix.equals("99")) {
			System.out.println("Veuillez saisir le code");
			String code = scanner.next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			String name = scanner.next();
			System.out.println("Veuillez saisir le prix");
			Double prix = scanner.nextDouble();

			Pizza modPizza = new Pizza(code, name, prix);
			if (pizzaDao.modifierPizza(choix, modPizza)) {
				System.out.println("Pizza modifiée avec succées !");
			} else {
				System.out.println("Erreur lors de la modification !");
			}
		} else {
			System.out.println("Modification annulée !");
		}
		return true;	
	}
}
