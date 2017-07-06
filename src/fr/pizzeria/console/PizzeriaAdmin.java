package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdmin {

	private static Scanner input;
	
	public static void main(String[] args) {
		
		PizzaDaoMemoire.initPizzas(50);
		input = new Scanner(System.in);
		Menu m = new Menu("***** Pizzeria Administration *****", 5);
		m.manage();
		input.close();
	}

	/**
	 * @return the input
	 */
	public static Scanner getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public static void setInput(Scanner input) {
		PizzeriaAdmin.input = input;
	}

}
