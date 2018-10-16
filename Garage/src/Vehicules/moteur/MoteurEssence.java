package Vehicules.moteur;

public class MoteurEssence extends Moteur {

	public MoteurEssence(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.ELECTRIQUE;
	}
}
