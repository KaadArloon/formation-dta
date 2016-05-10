package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		new Pizza().equals(new Pizza());
		Scanner sc = new Scanner(System.in);
		PizzaDaoFichier dao = new PizzaDaoFichier();
		Menu menuApplication = new Menu(sc, dao);
		menuApplication.afficher();
	}
}
