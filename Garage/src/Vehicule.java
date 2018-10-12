import java.io.Serializable;
import java.util.List;

abstract class Vehicule implements Serializable{
	protected Double prix;
	protected String nom;
	protected List<String> option;
	protected String marque;
	
	public String toString() {
		String toPrint = "+ Voiture ";
		toPrint += this.marque + " : ";
		toPrint += this.nom;
		toPrint += " Moteur " + "TBD" + " (" + this.prix + "€)" ;
		toPrint += "[ Options " + "TBD ]" ;
		toPrint += " d'une valeur totale de " + this.prix + " €";		
		return toPrint;
	}
	
	protected void addOption (String optionToAdd) {
	
	}
	
	public String getMarque() {
		return this.marque;
	}
	
	/*String getOptions(){
		for (int i = 0; i < option.size(); i++)
			returnText += " + Voiture " + (String) option.get(i) +"\n";
		return returnText
	}*/
	
	Double getPrix() {
		return prix;
	}

}
