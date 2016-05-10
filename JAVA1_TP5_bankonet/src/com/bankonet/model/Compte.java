package com.bankonet.model;

import com.bankonet.CompteStat;
import com.bankonet.CreditException;
import com.bankonet.DebitException;

/**
 * @author fguibert
 */
public abstract class Compte implements CompteStat {
	private String libelle;
	private int identifiant;
	protected float solde;

	Compte() {
	}

	Compte(int id, String libelle, float solde) {
		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;
	}

	public String toString() {
		return " ID  : " + this.getIdentifiant() + " - " + " Lib : " + this.getLibelle() + " - " + " Solde : "
				+ this.getSolde() + "€";
	}

	public void crediter(float montant) throws CreditException, BankonetException {
		if (creditAutorise(montant)){
		this.setSolde(this.getSolde() + montant);
		} else {
			throw new CreditException();
		}
	}

	public void debiter(float montant) throws DebitException, BankonetException {
		if (debitAutorise(montant)) {
			this.setSolde(this.getSolde() - montant);
		} else {
			throw new DebitException();
		}
	}
	
	public void effectuerVirement (Compte compte, float montant) throws DebitException, BankonetException, CreditException{
		this.debiter(montant);
		compte.crediter(montant);
	}

	public abstract boolean creditAutorise(float montant) throws BankonetException;

	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	private void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
