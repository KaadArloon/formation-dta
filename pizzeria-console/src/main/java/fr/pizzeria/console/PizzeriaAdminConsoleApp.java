package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoBDD;
import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminConsoleApp {
	
	private PizzeriaAdminConsoleApp() {
	}

	public static void main(String[] args) throws DaoException {

		ResourceBundle rbProperties = ResourceBundle.getBundle("application");
		String confString = rbProperties.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);

		PizzaDao dao;

		switch (daoImplConf) {
		case 3:
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console");
			
			dao = new PizzaDaoJpa(emf);
			lancerAppli(dao);
			break;
		case 2:
			ResourceBundle jdbcBundle = ResourceBundle.getBundle("jdbc");
			String driver = jdbcBundle.getString("SGBDR"); 
			String url = jdbcBundle.getString("URL");
			String user = jdbcBundle.getString("USER");
			String pass = jdbcBundle.getString("PASS");

			dao = new PizzaDaoBDD(driver, url, user, pass);
			lancerAppli(dao);
			break;
		case 0:
		case 1:
			System.err.println("Veuillez configurer l’application avec une implémentation base de données");
			break;
		default:
			System.err.println("Aucune configuration Dao trouvée. Le fichier application.properties est-il présent ?");
		}

	}

	private static void lancerAppli(PizzaDao dao) {
		try (Scanner sc = new Scanner(System.in)) {
			Menu menuApplication = new Menu(sc, dao);
			menuApplication.afficher();
		}
	}
	
}