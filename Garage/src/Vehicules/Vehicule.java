package Vehicules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Vehicules.moteur.Moteur;
import Vehicules.option.Option;

public abstract class Vehicule implements Serializable {
	protected Double prix;
	protected String nom;
	protected List<Option> myOption = new ArrayList<Option>();
	protected String marque;
	protected Moteur moteur;

	public String toString() {
		String toPrint = "+ Voiture ";
		toPrint += this.marque + " : ";
		toPrint += this.nom;
		toPrint += this.moteur.toString() + "[";
		for (int i = 0; i < myOption.size(); i++) {
			if (i != 0)
				toPrint += ", ";
			toPrint += myOption.get(i).getClass().getSimpleName() + " (" + myOption.get(i).getPrix() + "€)";
		}
		toPrint += "]";
		toPrint += " d'une valeur totale de " + this.prix + " €";
		return toPrint;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public void addOption(Option optionToAdd) {
		myOption.add(optionToAdd);
	}

	public void getOption() {
		String text = "";

		System.out.println(text);
	}

	public String getMarque() {
		return this.marque;
	}

	Double getPrix() {
		return prix;
	}

}
