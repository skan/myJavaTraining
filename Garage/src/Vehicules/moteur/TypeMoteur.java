package Vehicules.moteur;


public enum TypeMoteur {
	DIESEL("Moteur Diesel"), ESSENCE("Moteur Essence"), HYBRIDE("Moteur Hybride"), ELECTRIQUE("Moteur Electrique");

	private String nom = "";
	
	TypeMoteur(String pNom) {
		this.nom = pNom;
	}
	
	public String getNom()
	{
		return this.nom;
	}
}
