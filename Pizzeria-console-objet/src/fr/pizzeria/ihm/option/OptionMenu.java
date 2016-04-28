package fr.pizzeria.ihm.option;

public abstract class OptionMenu {
	protected String libelle;
	public abstract boolean execute();
	
	public OptionMenu(String omLibelle){
		this.libelle = omLibelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
