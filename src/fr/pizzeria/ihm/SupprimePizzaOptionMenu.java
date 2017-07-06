package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdmin;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;

public class SupprimePizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public SupprimePizzaOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		
		dao = new PizzaDaoMemoire();
		
		System.out.println("Veuillez choisir le code de la pizza à supprimer.");
		System.out.println("(99 pour abandonner)");
		
		String codeChosen = PizzeriaAdmin.getInput().next();
		
		if(!codeChosen.equals("99")) {
			dao.deletePizza(codeChosen);
		}
		
		return true;
	}

}
