package fr.pizzeria.dao;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	/**
	 * 
	 * @return la liste des pizzas stockées
	 */
	Pizza[] findAllPizzas();
	
	/**
	 * 
	 * @param pizza la pizza à stocker
	 * @return true si le stockage s'est bien passé, false sinon
	 * @throws SavePizzaException 
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	
	/**
	 * 
	 * @param codePizza le code de la pizza à mettre à jour
	 * @param pizza
	 * @return true si la modification s'est bien passé, false sinon
	 */
	boolean updatePizza(String codePizza, Pizza pizza);
	
	/**
	 * 
	 * @param codePizza le code de la pizza à supprimer
	 * @return true si la suppression s'est bien passé, false sinon
	 */
	boolean deletePizza(String codePizza);
}
