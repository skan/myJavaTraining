package Vehicules.modele;

import Vehicules.Vehicule;

public class A300B extends Vehicule {

	public A300B() {
		this.nom = Marque.PIGEOT.getNom();
		this.marque = Marque.PIGEOT.getMarque();
		this.prix = 28699.0;
	}

}
