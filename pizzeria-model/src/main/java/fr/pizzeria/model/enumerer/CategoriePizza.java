package fr.pizzeria.model.enumerer;

public enum CategoriePizza {
	VIANDE ("Viande"),
	POISSON ("Poisson"),
	SANS_VIANDE ("Sans_viande");
	
	private String value;
	
	private CategoriePizza(String s) {
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
