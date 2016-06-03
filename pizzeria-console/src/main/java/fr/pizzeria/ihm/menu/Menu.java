package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.ihm.option.AfficherPizzaOptionMenu;
import fr.pizzeria.ihm.option.AfficherPizzaPlusCherOptionMenu;
import fr.pizzeria.ihm.option.ListerPizzaParCategorieOptionMenu;
import fr.pizzeria.ihm.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.option.NouvellePizzaOptionMenu;
import fr.pizzeria.ihm.option.OptionMenu;
import fr.pizzeria.ihm.option.QuitterOptionMenu;
import fr.pizzeria.ihm.option.SupprimerPizzaOptionMenu;

@Component
public class Menu {

	private static final String TITRE_MENU_LIBELLE = "Pizzeria Administration";
	private Map<Integer, OptionMenu> listeOptions;
	private Scanner scanner;

	@Autowired
	public Menu(Scanner sc, /*@Qualifier("pizzaDaoImpl") */ IPizzaDao pizzaDao) {
		super();
		initialiserOptions(sc, pizzaDao);
		scanner = sc;
	}

	private void initialiserOptions(Scanner sc, IPizzaDao pizzaDao) {
		listeOptions = new TreeMap<>();
		listeOptions.put(1, new AfficherPizzaOptionMenu(pizzaDao));
		listeOptions.put(2, new NouvellePizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(3, new ModifierPizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(4, new SupprimerPizzaOptionMenu(pizzaDao, sc));
		listeOptions.put(5, new ListerPizzaParCategorieOptionMenu(pizzaDao));
		listeOptions.put(6, new AfficherPizzaPlusCherOptionMenu(pizzaDao));
		listeOptions.put(99, new QuitterOptionMenu());
	}

	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("***** " + TITRE_MENU_LIBELLE + " *****");
			
			listeOptions.entrySet().stream()
				.forEach(optionMenuEntry -> System.out.println(optionMenuEntry.getKey() + ". " + optionMenuEntry.getValue().getLibelle()));
			
			int saisie = scanner.nextInt();
			continuer = listeOptions.get(saisie).execute();
		}
	}
}
