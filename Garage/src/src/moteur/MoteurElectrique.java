package src.moteur;

public class MoteurElectrique extends Moteur {

	public MoteurElectrique(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.ELECTRIQUE;
	}
}
