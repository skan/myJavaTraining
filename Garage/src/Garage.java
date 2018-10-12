import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Garage implements Serializable {
	Garage() {
		System.out.println("Hello Garage");
	}

	@Override
	public String toString() {
		String garage_content = "Garage is under construction";
		return garage_content;
	}


}
