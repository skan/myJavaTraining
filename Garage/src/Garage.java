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

	public void save() {
		try {
			String filepath = "garage.txt";
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this);
			objectOut.close();
			System.out.println("The Garage is succesfully saved");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
