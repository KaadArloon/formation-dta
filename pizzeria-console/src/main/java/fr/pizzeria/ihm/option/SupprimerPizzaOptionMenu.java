package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	private static final String SUPPRIMER_UNE_PIZZA_LIBELLE_MENU = "Supprimer une pizza";
	
	private IPizzaDao pizzaDao;
	private Scanner scanner;

	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao, Scanner sc) {
		super(SUPPRIMER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		scanner = sc;
	}

	@Override
	public boolean execute() {
		new AfficherPizzaOptionMenu(pizzaDao).execute();

		System.out.println("Veuillez choisir le code de la pizza � supprimer.\n(99 pour abandonner).");
		String choix = scanner.next();

		if (!choix.equals("99")) {
			try {
				pizzaDao.supprimerPizza(choix);
				System.out.println("Pizza supprim�e avec succ�es !");
			} catch (DeletePizzaException e) {
				System.out.println("Erreur lors de la suppression !");
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Suppression annul�e !");
		}
		return true;
	}
}
