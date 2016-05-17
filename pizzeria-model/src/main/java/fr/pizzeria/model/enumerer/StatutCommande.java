package fr.pizzeria.model.enumerer;

public enum StatutCommande {
	EN_COURS ("En cours"),
	EN_LIVRAISON ("En livraison"),
	CLOSE ("Close"),
	NON_TRAITEE ("Non traitée");
	
	private String value;
	
	private StatutCommande(String s) {
		this.value = s;
	}
	
	public String getValue(){
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
