package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdmin;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.exception.CodeDontMatchException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	private IPizzaDao dao;
	
	public NouvellePizzaOptionMenu(String libelle) {
		super(libelle);
	}

	@Override
	public boolean execute() {
		String codeString = null;
		String nomString = null;
		String prixString = null;
		boolean correct = true;
		
		dao = new PizzaDaoMemoire();
		
		// Boucle tant que le code entré n'est pas bon
		do {
			correct = true;
			System.out.println("Veuillez saisir le code");
			try {
				codeString = PizzeriaAdmin.getInput().next();
				
				// Vérifie que le code soit composé de 3 lettres majuscules
				if(!codeString.matches("[A-Z]{3}")) {
					throw new CodeDontMatchException();
				}
			} catch (CodeDontMatchException e) {
				System.out.println(e.getMessage());
				correct = false;
			}
		} while (!correct);
		
		correct = true;
		// Boucle tant que le nom entré n'est pas bon
		do {
			correct = true;
			System.out.println("Veuillez saisir le nom (sans espace)");
			try {
				nomString = PizzeriaAdmin.getInput().next();
				
				// Vérifie que le nom ne contienne pas de chiffre
				if(!nomString.matches("[^0-9]*")) {
					throw new NameDontMatchException();
				}
			} catch (NameDontMatchException e) {
				System.out.println(e.getMessage());
				correct = false;
			}
		} while (!correct);
		
		System.out.println("Veuillez saisir le prix");
		prixString = PizzeriaAdmin.getInput().next();
		
		Pizza p = new Pizza(codeString, nomString, Double.parseDouble(prixString));
		try {
			dao.saveNewPizza(p);
		} catch (SavePizzaException e) {
			System.out.println(e.getMessage());
		}
		
		return true;
	}

}
