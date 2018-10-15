import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import src.moteur.Moteur;
import src.option.Option;

abstract class Vehicule implements Serializable {
	protected Double prix;
	protected String nom;
	protected List<Option> myOption = new ArrayList<Option>();
	protected String marque;
	protected Moteur moteur;

	public String toString() {
		String toPrint = "+ Voiture ";
		toPrint += this.marque + " : ";
		toPrint += this.nom;
		toPrint += this.moteur.toString();
		toPrint += "[ Options " + "TBD ]";
		toPrint += " d'une valeur totale de " + this.prix + " €";
		return toPrint;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	protected void addOption(Option optionToAdd) {
		myOption.add(optionToAdd);
	}
	
	public void getOption() {
		String text = "";
		for (int i = 0; i < myOption.size(); i++)
			text += myOption.get(i).getClass().getSimpleName() + "(" + myOption.get(i).getPrix()+")";
		System.out.println(text);
	}

	public String getMarque() {
		return this.marque;
	}
	

	Double getPrix() {
		return prix;
	}

}
