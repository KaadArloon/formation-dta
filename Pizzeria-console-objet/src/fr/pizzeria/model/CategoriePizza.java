package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE ("Viande"),
	POISSON ("Poisson"),
	SANS_VIANDE ("Sans viande");
	
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
