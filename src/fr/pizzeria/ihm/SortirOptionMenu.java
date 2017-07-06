package fr.pizzeria.ihm;

public class SortirOptionMenu extends OptionMenu {

	public SortirOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		
		System.out.println("Aurevoir ♪");
		
		return true;
	}

}
