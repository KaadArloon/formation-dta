package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.Resultat;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private static Pizza[] getTableauPizza() {
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = creerPizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = creerPizza("MAR", "Margherita", 14.00);
		pizzas[2] = creerPizza("REI", "La Reine", 11.50);
		pizzas[3] = creerPizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = creerPizza("CAN", "La cannibale", 12.50);
		pizzas[5] = creerPizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = creerPizza("ORI", "L’orientale", 13.50);
		pizzas[7] = creerPizza("IND", "L’indienne", 14.00);
		return pizzas;
	}

	private static Pizza creerPizza(String code, String nom, double prix) {
		Pizza p = new Pizza(code, nom, prix);
		return p;
	}

	public static void main(String[] args) {
		int choix;
		Pizza[] listePizza = getTableauPizza();

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("  1. Lister les pizzas");
			System.out.println("  2. Ajouter une nouvelle pizza");
			System.out.println("  3. Mettre à jour une pizza");
			System.out.println("  4. Supprimer une pizza");
			System.out.println("100. Sortir");
			sc = new Scanner(System.in);
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				afficherPizza(listePizza);
				break;
			case 2:
				System.out.println("Ajout d’une nouvelle pizza");
				demandeNouvellePizza(sc, listePizza);
				afficherPizza(listePizza);
				break;
			case 3:
				System.out.println("Mise à jour d’une pizza");

				afficherPizza(listePizza);

				System.out.println("Veuillez choisir le code de la pizza à modifier.\n(100 pour annuler)");
				String choixMod = sc.next();

				if (choixMod.equals("100")) {
					System.out.println("");
				} else {
					Resultat pMod = recherchePizza(choixMod, listePizza);
					listePizza[pMod.index].code = pMod.pizzaTrouvee.code;
					listePizza[pMod.index].nom = pMod.pizzaTrouvee.nom;
					listePizza[pMod.index].prix = pMod.pizzaTrouvee.prix;
				}

				break;
			case 4:
				System.out.println("Suppression d’une pizza");
				break;
			case 100:
				System.out.println("Au revoir !");
			default:
				break;
			}
		} while (choix >= 100);
		sc.close();
	}

	private static Resultat recherchePizza(String choixMod, Pizza[] listePizza) {
		int i = 0, index;
		Pizza pizzaTrouvee;
		Resultat res;
		while (i < listePizza.length && !listePizza[i].code.equals(choixMod)) {
			i++;
		}
		if (i >= listePizza.length) {
			pizzaTrouvee = new Pizza("???", "pizza inconnue", 0);
			index = -1;
		} else {
			pizzaTrouvee = new Pizza(listePizza[i].code, listePizza[i].nom, listePizza[i].prix);
			index = i;
		}
		res = new Resultat(pizzaTrouvee, index);
		return res;
	}

	private static void demandeNouvellePizza(Scanner sc, Pizza[] listePizza) {
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = sc.next();
		System.out.println("Veuillez saisir le prix");
		Double prix = sc.nextDouble();

		int i = 0;
		do {
			i++;
		} while (i < listePizza.length && listePizza[i] != null);
		System.out.println(code);
		listePizza[i] = creerPizza(code, name, prix);
	}

	private static void afficherPizza(Pizza[] listePizza) {
		int i = 0;
		System.out.println("Liste des pizzas");

		while (i < listePizza.length) {
			if (listePizza[i] != null) {
				System.out.println(listePizza[i].code + " -> " + listePizza[i].nom + " " + listePizza[i].prix + "€");
			}
			i++;
		}

		System.out.println("------- " + Pizza.nbPizzas + " pizzas créées depuis l’initialisation du programme");
	}
}
