package fr.pizzeria.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private Main(){}

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml")) {
			AfficherMenu menu = context.getBean(AfficherMenu.class);
			menu.afficher();
		}
	}

}
