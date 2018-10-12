import java.io.Serializable;

public class MoteurDiesel extends Moteur implements Serializable {

	MoteurDiesel(String Cylindre, Double Prix) {
		super(Cylindre, Prix);
		this.Moteur = TypeMoteur.DIESEL;
	}
}
