package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminConsoleApp {
	
	private PizzeriaAdminConsoleApp() {
	}

	public static void main(String[] args) throws DaoException {
		Logger.getLogger("org").setLevel(Level.SEVERE);

		ResourceBundle rbProperties = ResourceBundle.getBundle("application");
		String confString = rbProperties.getString("dao.impl");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml", confString)) {
			IPizzaDao dao = context.getBean(IPizzaDao.class);
			lancerAppli(dao);
		}

	}
	
	private static void lancerAppli(IPizzaDao dao) {
		try (Scanner sc = new Scanner(System.in)) {
			Menu menuApplication = new Menu(sc, dao);
			menuApplication.afficher();
		}
	}
	
}