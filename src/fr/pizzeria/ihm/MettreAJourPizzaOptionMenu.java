package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdmin;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public MettreAJourPizzaOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		
		dao = new PizzaDaoMemoire();
		
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		System.out.println("(99 pour abandonner)");
		
		String codeChosen = PizzeriaAdmin.getInput().next();
		
		if(!codeChosen.equals("99")) {
		
			String codeString;
			String nomString;
			String prixString;
			
			System.out.println("Veuillez saisir le code");
			codeString = PizzeriaAdmin.getInput().next();
			System.out.println("Veuillez saisir le nom (sans espace)");
			nomString = PizzeriaAdmin.getInput().next();
			System.out.println("Veuillez saisir le prix");
			prixString = PizzeriaAdmin.getInput().next();
			
			Pizza p = new Pizza(codeString, nomString, Double.parseDouble(prixString));
			dao.updatePizza(codeChosen, p);
		}
		
		return true;
	}

}
