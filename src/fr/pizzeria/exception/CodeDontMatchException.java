package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class CodeDontMatchException extends Exception {
	
	public CodeDontMatchException() {
		super("Le code doit contenir exactement 3 lettres majuscules");
	}
	
	public CodeDontMatchException(String message) {
		super(message);
	}

}
