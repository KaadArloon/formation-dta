package fr.pizzeria.ihm.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu{

	private static final String AJOUTER_UNE_PIZZA_LIBELLE_MENU = "Ajouter une nouvelle pizza";
	
	private PizzaDao pizzaDao;
	private Scanner scanner;
	private CategoriePizza[] categories;

	public NouvellePizzaOptionMenu(PizzaDao pizzaDao, Scanner sc) {
		super(AJOUTER_UNE_PIZZA_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
		this.categories = CategoriePizza.values();
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
		System.out.println("Veuillez choisir la categorie");
		afficherCategories();
		int choixCategorie = scanner.nextInt();
		CategoriePizza categorie = categories[choixCategorie];
		
		Pizza nvPizza = new Pizza(code, name, prix, categorie);
		try {
			pizzaDao.nouvellePizza(nvPizza);
			System.out.println("Nouvelle pizza ajoutée");
		} catch (SavePizzaException e) {
			System.out.println("Erreur lors de l'insertion");
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	private void afficherCategories() {
		for (CategoriePizza cp : categories){
			System.out.println(cp.ordinal() + " -> " + cp.getValue());
		}
		
	}

}
