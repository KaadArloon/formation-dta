package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class CreerFichierStockage extends OptionMenu{

	private static final String MODIFIER_UNE_PIZZA_LIBELLE_MENU = "Mettre à jour une pizza";
	
	private PizzaDao pizzaDao;
	private Scanner scanner;
	private CategoriePizza[] categories;

	public CreerFichierStockage(PizzaDao pizzaDao, Scanner sc) {
		super(MODIFIER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		this.categories = CategoriePizza.values();
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
			System.out.println("Veuillez choisir la categorie");
			afficherCategories();
			int choixCategorie = scanner.nextInt();
			CategoriePizza categorie = categories[choixCategorie];

			Pizza modPizza = new Pizza(code, name, prix, categorie);
			try {
				pizzaDao.modifierPizza(choix, modPizza);
				System.out.println("Pizza modifiée avec succées !");
			} catch (UpdatePizzaException e) {
				System.out.println("Erreur lors de la modification !");
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Modification annulée !");
		}
		return true;	
	}

	private void afficherCategories() {
		System.out.println("0" + CategoriePizza.VIANDE.getValue());
		System.out.println("1" + CategoriePizza.POISSON.getValue());
		System.out.println("2" + CategoriePizza.SANS_VIANDE.getValue());
	}
}
