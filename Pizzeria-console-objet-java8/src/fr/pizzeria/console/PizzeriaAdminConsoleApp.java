package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PizzaDao dao = new PizzaDaoFichier();
		Menu menuApplication = new Menu(sc, dao);
		
		menuApplication.afficher();
	}
}
