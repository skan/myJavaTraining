
public enum Marque {
	RENO("RENO","Lagouna"), PIGEOT("PIGEOT","A330B"), TROEN("TROEN","D4");

	private String nomMarque = "";
	private String nom ="";
	
	Marque(String nomMarque, String nom) {
		this.nomMarque = nomMarque;
		this.nom = nom;
	}
	
	public String toString () {
		return nomMarque;
	}
	public String getMarque()
	{
		return this.nomMarque;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	
}
