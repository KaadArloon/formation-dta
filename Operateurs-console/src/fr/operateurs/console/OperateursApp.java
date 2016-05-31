package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		Double nb1, nb2, res;
		Scanner sc = new Scanner(System.in);
		System.out.println("***** Application Opérateurs *****");
		System.out.println("Veuillez saisir le premier nombre...");
		nb1 = sc.nextDouble();
		System.out.println("Veuillez saisir le second nombre...");
		nb2 = sc.nextDouble();
		sc.close();
		res = nb1 + nb2;
		System.out.println(nb1 + " + " + nb2 + " = " + res);
		res = nb1 - nb2;
		System.out.println(nb1 + " - " + nb2 + " = " + res);
		res = nb1 * nb2;
		System.out.println(nb1 + " * " + nb2 + " = " + res);
		if (nb2 != 0) {
			res = nb1 / nb2;
			System.out.println(nb1 + " / " + nb2 + " = " + res);
			res = nb1 % nb2;
			System.out.println(nb1 + " % " + nb2 + " = " + res);
		} else {
			System.out.println("Division par 0 impossible");
		}
		
		

	}
}
