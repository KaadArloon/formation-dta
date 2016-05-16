package fr.pizzeria.ihm.option;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DaoException;
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
		System.out.println("Ajout d�une nouvelle pizza");

		Pizza newPizza = new Pizza();
		
		System.out.println("Veuillez saisir le code");
		newPizza.setCode(scanner.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		newPizza.setNom(scanner.next());
		System.out.println("Veuillez saisir le prix");
		
		try {
			newPizza.setPrix(BigDecimal.valueOf(scanner.nextDouble()));
			System.out.println("Veuillez choisir la categorie");
			afficherCategories();
			int choixCategorie = scanner.nextInt();
			newPizza.setCategorie(categories[choixCategorie]);
		
		
			pizzaDao.nouvellePizza(newPizza);
			System.out.println("Nouvelle pizza ajout�e");
		} catch (InputMismatchException e) {
			System.err.println("Input " + scanner.next() + " n'est pas un nombre");
		} catch (DaoException e) {
			System.err.println("Echec cr�ation de pizza");
		}

		return true;
	}
	
	private void afficherCategories() {
		for (CategoriePizza cp : categories){
			System.out.println(cp.ordinal() + " -> " + cp.getValue());
		}	
	}
}
