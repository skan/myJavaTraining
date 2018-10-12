import java.io.Serializable;
import java.util.ArrayList;

public class Garage implements Serializable {

	ArrayList<String> al_content = new ArrayList<String>();

	Garage() {
		System.out.println("Hello Garage");
	}

	@Override
	public String toString() {
		String returnText ="************************\n";
		returnText +="* Garage Open Classroom \n";
		returnText +="************************\n";
		for (int i = 0; i < al_content.size(); i++)
			returnText += " + Voiture " + (String) al_content.get(i) +"\n";
		return returnText;
	}

	public void add(String nomVoiture) {
		al_content.add(nomVoiture);
	}
}
