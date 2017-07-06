package fr.pizzeria.ihm;

public abstract class OptionMenu {

	private String libelle;
	
	public OptionMenu(String libelle) {
		this.libelle = libelle;
	}
	
	abstract public boolean execute();

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
