package src.option;

import java.io.Serializable;

public class SiegeChauffant implements Option , Serializable{

	double prix = 562.9;

	public double getPrix() {
		return this.prix;
	}

}
