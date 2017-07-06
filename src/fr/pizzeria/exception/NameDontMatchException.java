package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class NameDontMatchException extends Exception {

	public NameDontMatchException() {
		super("Le nom ne doit pas contenir de chiffre");
	}
	
	public NameDontMatchException(String message) {
		super(message);
	}
}
