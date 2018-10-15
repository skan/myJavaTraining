package src.option;


public interface Option {
	
	 double prix = 0;

	default public double getPrix() {
		return this.prix;
	}

}
