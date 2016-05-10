package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Modelise un client de bankonet.
 *
 * <p>
 * Un client est caracterise par :
 * <ul>
 * <li>son identifiant unique
 * <li>son nom
 * <li>son prenom
 * <li>la liste de ses comptes
 * </ul>
 *
 * @author fguibert
 */
public class Client {
	private int identifiant;
	private String nom;
	private String prenom;
	private List<Compte> comptes = new ArrayList<Compte>();

	/**
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 */
	public Client(int identifiant, String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
	}

	public Client(int identifiant, String nom, String prenom, List<Compte> cList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.comptes = cList;
	}

	public Client(int identifiant, String nom, String prenom, List<CompteCourant> ccList, List<CompteEpargne> ceList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.comptes.addAll(ccList);
		this.comptes.addAll(ceList);
	}

	public String toString() {
		return " ID  : " + this.getIdentifiant() + " - " + " Nom : " + this.getNom() + " - " + " Prénom : "
				+ this.getPrenom();
	}

	public float calculerAvoirGLobal() {
		List<Compte> tousLesComptes = new ArrayList<Compte>(this.comptes);
		float soldeTotal = 0;
		for (Compte myC : tousLesComptes) {
			soldeTotal += myC.getSolde();
		}
		return soldeTotal;
	}
	
	public void creerCompte (Compte compte){
		comptes.add(compte);
	}
	
	public void supprimerCompte (Compte compte){
		comptes.remove(compte);
	}
	
	public void supprimerCompte (String numero){
		
	}

	/**
	 * @param comptes
	 *            The comptes to set.
	 */
	public void setCompteCourantList(List<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * Retourne la liste des comptes du client sous forme d'une ArrayList (de
	 * taille 0 si pas de compte).
	 * 
	 * @return List
	 */
	public List<Object> getComptes() {
		return Collections.unmodifiableList(comptes);

	}

	public Compte getCompte(int compteId) {
		List<Compte> compteList = comptes;
		Iterator<Compte> compteIte = compteList.iterator();
		while (compteIte.hasNext()) {
			Compte compte = (Compte) compteIte.next();
			if (compteId == compte.getIdentifiant())
				return compte;
		}
		return null;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * Retourne le nom du client.
	 *
	 * @return java.lang.String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne le prenom du client.
	 * 
	 * @return java.lang.String
	 */
	public String getPrenom() {
		return prenom;
	}
}
