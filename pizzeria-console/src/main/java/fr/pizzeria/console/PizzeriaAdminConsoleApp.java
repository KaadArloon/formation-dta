package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		ResourceBundle rbProperties = ResourceBundle.getBundle("application");
		String confString = rbProperties.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);

		PizzaDao dao;
		System.out.println()

		switch (daoImplConf) {
		case 0:
			dao = new PizzaDaoImpl();
			lancerAppli(dao);
			break;
		case 1:
			dao = new PizzaDaoFichier();
			lancerAppli(dao);
			break;
		default:
			System.err.println("Aucune configuration Dao trouvée. Le fichier application.properties est-il présent ?");
		}

		new Pizza().equals(new Pizza());

	}

	private static void lancerAppli(PizzaDao dao) {
		try (Scanner sc = new Scanner(System.in)) {
			Menu menuApplication = new Menu(sc, dao);
			menuApplication.afficher();
		}
	}
}
