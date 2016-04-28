package fr.pizzeria.ihm.option;

public abstract class OptionMenu {
	protected final String libelle;
	
	/**
	 * Cette fontion execute l'action de l'option et renvoie vrai si il faut réafficher le menu
	 */
	public abstract boolean execute();
		
	public OptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}	
}
