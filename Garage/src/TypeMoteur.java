
public enum TypeMoteur {
	DIESEL("Moteur Diesel"), ESSENCE("Moteur Essence"), HYBRIDE("Moteur Hybride"), ELECTRIQUE("Moteur Electrique");

	private String nom = "";
	
	TypeMoteur(String nom) {
		this.nom = nom;
	}
	
	public String getNom()
	{
		return this.nom;
	}
}
