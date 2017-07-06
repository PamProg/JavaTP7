package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class PriceDontMatchException extends Exception {

	public PriceDontMatchException() {
		super("Le prix doit être positif et doit contenir uniquement des chiffres, séparés par un et un seul point \".\"");
	}
	
	public PriceDontMatchException(String message) {
		super(message);
	}
}
