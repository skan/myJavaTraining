package src.moteur;


public class MoteurHybride extends Moteur {

	public MoteurHybride(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.HYBRIDE;
	}
}
