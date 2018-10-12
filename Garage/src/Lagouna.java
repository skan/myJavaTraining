
public class Lagouna extends Vehicule {

	Lagouna() {
		this.nom = "Lagouna";
		this.marque = "Reno";
		this.prix = (double)23123;
	}

	public void addOption(String optionToAdd) {
		this.option.add(optionToAdd);
	}

}
