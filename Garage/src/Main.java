import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
	public static void main(String[] args) {
		Garage garage = new Garage();
		//garage = load ();
		garage.add("Skooda");
		garage.add("peugeot");
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
			fileOut.close();
			System.out.println("The Garage is succesfully saved");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	static Garage load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Garage garage = new Garage();

		try {
			fis = new FileInputStream(new File("garage.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			garage = (Garage) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return garage;
	}

}
