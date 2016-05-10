package fr.pizzeria.ihm.option;

public class QuitterOptionMenu extends OptionMenu {

	private static final String QUITTER_LIBELLE_MENU = "Quitter";

	public QuitterOptionMenu() {
		super(QUITTER_LIBELLE_MENU);
	}

	@Override
	public boolean execute() {
		System.out.println("Au revoir !");
		return false;
	}

}
