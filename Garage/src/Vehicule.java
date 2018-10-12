import java.util.List;

abstract class Vehicule {
	protected Double prix;
	protected String nom;
	protected List<String> option;
	protected String marque;
	
	public String toString() {
		String VehiculeCharac = this.nom;
		return VehiculeCharac;
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
