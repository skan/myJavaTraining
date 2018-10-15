import java.io.Serializable;
import java.util.List;
import src.moteur.*;

abstract class Vehicule implements Serializable {
	protected Double prix;
	protected String nom;
	protected List<Option> options;
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

	protected void addOption(String optionToAdd) {

	}

	public String getMarque() {
		return this.marque;
	}

	String getOptions(){
		String returnText;
		for (int i = 0; i < options.size(); i++)
			returnText += option.getPrix(); + (String) option.get(i) +"\n";
		return returnText;
	}

	Double getPrix() {
		return prix;
	}

}
