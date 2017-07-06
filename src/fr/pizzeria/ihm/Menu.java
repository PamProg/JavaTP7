package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdmin;

public class Menu {

	// Déclaration des variables
	private String titre;
	private OptionMenu[] actions;
	
	public Menu(String titre, int nbActions) {
		this.titre = titre;
		actions = new OptionMenu[nbActions];
	}
	
	public void manage() {
		initActions();
		
		int response = -1;
		
		// Afficher le menu tant qu'on ne sort pas (ie : response = 99)
		do {
			afficherMenu();
			
			response = PizzeriaAdmin.getInput().nextInt();
			
			switch (response) {
				case 1: 
					System.out.println("Liste des pizzas"); 
					actions[0].execute();
					break; 
				case 2: 
					System.out.println("Ajout d'une nouvelle pizza"); 
					actions[1].execute();
					break; 
				case 3: 
					actions[0].execute();
					System.out.println("Mise à jour d'une pizza");
					actions[2].execute();
					break; 
				case 4: 
					actions[0].execute();
					System.out.println("Suppression d'une pizza");
					actions[3].execute();
					break; 
				case 99: 
					actions[4].execute();
					break; 
//				default:
//					break;
			}
		} while (response != 99);
		
	}
	
	private void initActions() {
		actions[0] = new ListerPizzasOptionMenu("1. Lister les pizzas");
		actions[1] = new NouvellePizzaOptionMenu("2. Ajouter une nouvelle pizza");
		actions[2] = new MettreAJourPizzaOptionMenu("3. Mettre à jour une pizza");
		actions[3] = new SupprimePizzaOptionMenu("4. Supprimer une pizza");
		actions[4] = new SortirOptionMenu("99. Sortir");
	}

	public void afficherMenu() {
		System.out.println(titre);
		
		for(OptionMenu o : actions) {
			System.out.println(o.getLibelle());
		}
	}
	
	/**
	 * @param indice l'indice de l'action à ajouter
	 * @param action l'action à ajouter
	 */
	public void setAction(int indice, OptionMenu action) {
		actions[indice] = action;
	}
	
	/**
	 * @return the actions
	 */
	public OptionMenu[] getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(OptionMenu[] actions) {
		this.actions = actions;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	
}
