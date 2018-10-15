import java.io.Serializable;
import java.util.ArrayList;

public class Garage implements Serializable {

	ArrayList<Vehicule> al_content = new ArrayList<Vehicule>();

	Garage() {

	}

	@Override
	public String toString() {
		String returnText ="************************\n";
		returnText +="* Garage Open Classroom \n";
		returnText +="************************\n";
		for (int i = 0; i < al_content.size(); i++)
			returnText += al_content.get(i).toString() +"\n";
		return returnText;
	}

	public void addVoiture(Vehicule nomVoiture) {
		al_content.add(nomVoiture);
	}
}
