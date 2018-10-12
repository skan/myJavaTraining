import java.util.List;

public class Voiture {
	Double prix;
	String nom;
	List<String> option;
	String marque;
	
	public String toString() {
		return nom;
	}
	
	public void addOption (String optionToAdd) {
		option.add(optionToAdd);
	}
	
	public String getMarque() {
		return marque;
	}
	
	List<String> getOptions(){
		return option;
	}
	
	Double getPrix() {
		return prix;
	}

}
