public class MoteurEssence extends Moteur {

	MoteurEssence(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.ELECTRIQUE;
	}
}
