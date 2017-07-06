package fr.pizzeria.dao;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMemoire implements IPizzaDao {

	static private Pizza[] pizzas;
	
	/**
	 * Initialise les pizzas originelles
	 */
	static public void initPizzas(int nbPizzas) {
		
		pizzas = new Pizza[nbPizzas];
		
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REI", "LA Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		int nbPizzas = 0;
		
		for(int i=0 ; i<pizzas.length ; i++) {
			if(pizzas[i] != null) {
				nbPizzas++;
			}
		}
		
		for(int i=0 ; i<nbPizzas ; i++) {
			// On vérifie que le code n'existe pas déjà parmi les pizzas
			if(pizzas[i].getCode().equals(pizza.getCode())) {
				throw new SavePizzaException(("Erreur : Le code de la pizza existe déjà. Pizza non sauvée"));
			}
		}
		
		pizza.setId(nbPizzas);
		pizzas[pizza.getId()] = pizza;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		
		for(int i=0 ; i<pizzas.length ; i++) {
			if(pizzas[i] != null && pizzas[i].getCode().equals(codePizza)) {
				pizzas[i].setCode(pizza.getCode());
				pizzas[i].setNom(pizza.getNom());
				pizzas[i].setPrix(pizza.getPrix());
			}
		}
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		
		int indexPizzaDelete = -1;
		
		// Récupère l'indice de la pizza supprimée
		for(int i=0 ; i<pizzas.length ; i++) {
			if(pizzas[i] != null && pizzas[i].getCode().equals(codePizza)) {
				indexPizzaDelete = i;
			}
		}
		
		// Permet de "tasser" le tableau après la suppression
		for(int i=indexPizzaDelete ; i<pizzas.length ; i++) {
			if(pizzas[i] != null) {
				pizzas[i] = pizzas[i+1];
			}
		}
		
		return true;
	}
}
