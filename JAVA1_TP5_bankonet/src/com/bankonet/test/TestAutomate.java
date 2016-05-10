package com.bankonet.test;

import com.bankonet.CompteStat;

public class TestAutomate {
	public static void main(String... args) {
		CompteStat[] cS = DonneesTest.construitEchantillonComptes();
		float sommeSolde = 0;
		for (CompteStat c : cS){
			sommeSolde += c.getSolde();
		}
		
		System.out.println("Moyenne des soldes des comptes : " + sommeSolde/cS.length);
	}
}
