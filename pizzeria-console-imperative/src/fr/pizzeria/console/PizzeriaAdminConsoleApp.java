package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		int choix;
		
		Object [][] listePizza  = new Object[100][];
		listePizza[0] =	new Object[] {"PEP", "Pépéroni", 12.50};
		listePizza[1] =	new Object[] {"MAR", "Margherita", 14.00};
		listePizza[2] =	new Object[] {"REI", "La Reine", 11.50};
		listePizza[3] =	new Object[] {"FRO", "La 4 fromages", 12.00};
		listePizza[4] =	new Object[] {"CAN", "La cannibale", 12.50};
		listePizza[5] =	new Object[] {"SAV", "La savoyarde", 13.00};
		listePizza[6] =	new Object[] {"ORI", "L’orientale", 13.50};
		listePizza[7] =	new Object[] {"IND", "L’indienne", 14.00};
		
		Scanner sc;
		
		do{
			int i = 0;
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("  1. Lister les pizzas");
			System.out.println("  2. Ajouter une nouvelle pizza");
			System.out.println("  3. Mettre à jour une pizza");
			System.out.println("  4. Supprimer une pizza");
			System.out.println("100. Sortir");
			sc = new Scanner(System.in);
			choix = sc.nextInt();
			switch(choix){
				case 1 :
					System.out.println("Liste des pizzas");
					
					while(i < listePizza.length){
						if (listePizza[i] != null){
							System.out.println( listePizza[i][0] + " -> " + listePizza[i][1] + " " + listePizza[i][2]);
						}
						i++;
					}
					break;
				case 2 :
					System.out.println("Ajout d’une nouvelle pizza");
					
					System.out.println("Veuillez saisir le code");
					String code = sc.next();
					System.out.println("Veuillez saisir le nom (sans espace)");
					String name = sc.next();
					System.out.println("Veuillez saisir le prix");
					Double prix = sc.nextDouble();
					i = 0;
					do{
						i++;
					}while(i < listePizza.length && listePizza[i] != null);
					System.out.println(code);
					listePizza[i] = new Object[] {code, name, prix};
					
					break;
				case 3 :
					System.out.println("Mise à jour d’une pizza");
					
					while(i < listePizza.length){
						if (listePizza[i] != null){
							System.out.println( i + " " + listePizza[i][0] + " -> " + listePizza[i][1] + " " + listePizza[i][2]);
						}
						i++;
					}
					
					System.out.println("Veuillez choisir le numéro de la pizza à modifier.\n (100 pour annuler)");
					
					break;
				case 4 :
					System.out.println("Suppression d’une pizza");
					break;
				default :
					System.out.println("Au revoir !");
					break;
			}
		}while(choix != 99);
		sc.close();
	}
}
