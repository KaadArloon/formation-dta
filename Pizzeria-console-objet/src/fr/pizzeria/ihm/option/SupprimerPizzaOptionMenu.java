package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	private static final String SUPPRIMER_UNE_PIZZA_LIBELLE_MENU = "Supprimer une pizza";
	
	private PizzaDao pizzaDao;
	private Scanner scanner;

	public SupprimerPizzaOptionMenu(PizzaDao pizzaDao, Scanner sc) {
		super(SUPPRIMER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		scanner = sc;
	}

	@Override
	public boolean execute() {
		new AfficherPizzaOptionMenu(pizzaDao).execute();

		System.out.println("Veuillez choisir le code de la pizza à supprimer.\n(99 pour abandonner).");
		String choix = scanner.next();

		if (!choix.equals("99")) {
			try {
				pizzaDao.supprimerPizza(choix);
				System.out.println("Pizza supprimée avec succées !");
			} catch (DeletePizzaException e) {
				System.out.println("Erreur lors de la suppression !");
				e.printStackTrace();
			}
		} else {
			System.out.println("Suppression annulée !");
		}
		return true;
	}
}
