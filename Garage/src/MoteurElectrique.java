import java.io.Serializable;

public class MoteurElectrique extends Moteur {

	MoteurElectrique(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.ELECTRIQUE;
	}
}
