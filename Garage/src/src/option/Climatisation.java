package src.option;

import java.io.Serializable;

public class Climatisation implements Option,Serializable {
	private double prix = 347.3;

	public double getPrix() {
		return this.prix;
	}
}
