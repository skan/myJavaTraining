package src.option;

import java.io.Serializable;

public class GPS implements Option,Serializable {
	private double prix = 113.5;
	public double getPrix() {
		return this.prix;
	}
	
}
