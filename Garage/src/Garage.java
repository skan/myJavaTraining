import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Garage implements Serializable {
	
	String garage_content = "Garage is under construction";
	
	Garage() {
		System.out.println("Hello Garage");
	}

	@Override
	public String toString() {
		return garage_content;
	}
	
	public void add (String nomVoiture) {
		garage_content = nomVoiture;
	}
}
