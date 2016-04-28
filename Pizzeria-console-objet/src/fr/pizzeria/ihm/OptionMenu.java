package fr.pizzeria.ihm;

public abstract class OptionMenu {
	protected String libelle;
	public abstract void execute();
	
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
