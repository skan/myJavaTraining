package src.option;

import java.io.Serializable;

public class VitreElectrique implements Option, Serializable {
	private double prix = 212.35;

	public double getPrix() {
		return this.prix;
	}
}
