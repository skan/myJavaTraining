package src.option;

import java.io.Serializable;

public class BarreDeToit implements Option,Serializable {
	private double prix = 29.9;

	public double getPrix() {
		return this.prix;
	}
}
