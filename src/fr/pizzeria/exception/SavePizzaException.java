package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class SavePizzaException extends Exception {

	public SavePizzaException() {
		super("Erreur lors de la sauvegarde de la pizza. Pizza non sauvée.");
	}
	
	public SavePizzaException(String message) {
		super(message);
	}
}
