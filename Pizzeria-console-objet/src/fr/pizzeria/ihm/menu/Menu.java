package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.option.AfficherPizzaOptionMenu;
import fr.pizzeria.ihm.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.option.NouvellePizzaOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.QuitterOptionMenu;
import fr.pizzeria.ihm.option.SupprimerPizzaOptionMenu;

public class Menu {

	private static final String TITRE_MENU_LIBELLE = "Pizzeria Administration";
	public String titre;
	public OptionMenu[] listeOptions;
	public Scanner scanner;

	public Menu(Scanner sc, PizzaDao pizzaDao) {
		super();
		initialiserOptions(sc, pizzaDao);
		scanner = sc;
	}

	private void initialiserOptions(Scanner sc, PizzaDao pizzaDao) {
		listeOptions = new OptionMenu[] { 
				new AfficherPizzaOptionMenu(pizzaDao),
				new NouvellePizzaOptionMenu(pizzaDao, sc),
				new ModifierPizzaOptionMenu(pizzaDao, sc),
				new SupprimerPizzaOptionMenu(pizzaDao, sc),
				new QuitterOptionMenu() };
	}

	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("***** " + TITRE_MENU_LIBELLE + " *****");
			int i = 0;
			for (OptionMenu opt : listeOptions) {
				System.out.println(i + " -> " + opt.getLibelle());
				i++;
			}
			int saisie = scanner.nextInt();
			continuer = listeOptions[saisie].execute();
		}
	}
}
