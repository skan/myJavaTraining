import java.io.Serializable;

abstract class Moteur implements Serializable{
	protected TypeMoteur Moteur;
	protected String Cylindre;
	protected Double Prix;

	Moteur(String Cylindre, Double Prix) {
		this.Cylindre = Cylindre;
		this.Prix = Prix;
	}

	public String toString() {
		String toPrint = Moteur.getNom() + " " + Cylindre + " (" + Prix +"€)";
		return toPrint;
	}
	
	Double getPrix() {
		return this.Prix;
	}

}
