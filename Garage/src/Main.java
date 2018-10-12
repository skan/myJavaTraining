import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) {
		Garage garage = new Garage();
		System.out.println(garage);
		save(garage);
	}
	
	static void save(Garage garage) {
		try {
			String filepath = "garage.txt";
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(garage);
			objectOut.close();
			System.out.println("The Garage is succesfully saved");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
