package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.Map;
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
	public Map<Integer, OptionMenu> listeOptions;
	public Scanner scanner;

	public Menu(Scanner sc, PizzaDao pizzaDao) {
		super();
		initialiserOptions(sc, pizzaDao);
		scanner = sc;
	}

	private void initialiserOptions(Scanner sc, PizzaDao pizzaDao) {
		listeOptions = new HashMap<Integer, OptionMenu>();
		listeOptions.put(0, new AfficherPizzaOptionMenu(pizzaDao));
		listeOptions.put(1, new NouvellePizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(2, new ModifierPizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(3, new SupprimerPizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(4, new QuitterOptionMenu());
	}

	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("***** " + TITRE_MENU_LIBELLE + " *****");
			for (Integer key : listeOptions.keySet()) {
				System.out.println( key + " -> " + listeOptions.get(key).getLibelle());
			}
			int saisie = scanner.nextInt();
			continuer = listeOptions.get(saisie).execute();
		}
	}
}
