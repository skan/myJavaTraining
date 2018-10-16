package src.moteur;

import java.io.Serializable;

public abstract class Moteur implements Serializable{
	protected TypeMoteur Moteur;
	protected String Cylindre;
	protected Double Prix;

	Moteur(String Cylindre, Double Prix) {
		this.Cylindre = Cylindre;
		this.Prix = Prix;
	}

	public String toString() {
		return Moteur.getNom() + " " + Cylindre + " (" + Prix +"€)";
	}
	
	Double getPrix() {
		return this.Prix;
	}

}
