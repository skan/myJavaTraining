import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Vehicules.Vehicule;
import Vehicules.A300B;
import Vehicules.D4;
import Vehicules.Lagouna;
import src.moteur.MoteurDiesel;
import src.moteur.MoteurElectrique;
import src.moteur.MoteurEssence;
import src.moteur.MoteurHybride;
import src.option.BarreDeToit;
import src.option.Climatisation;
import src.option.GPS;
import src.option.SiegeChauffant;
import src.option.VitreElectrique;

public class Main {
	public static void main(String[] args) {
		Garage garage = new Garage();

		File f = new File("garage.txt");
		boolean isLoadOk = false;

		if (f.isFile() && f.canRead() && isLoadOk) {
			garage = load();
		} else {

			Vehicule lag1 = new Lagouna();
		   	 lag1.setMoteur(new MoteurEssence("150 Chevaux", 10256d));
		   	 lag1.addOption(new GPS());
		   	 lag1.addOption(new SiegeChauffant());
		   	 lag1.addOption(new VitreElectrique());
		   	 garage.addVoiture(lag1);
		   		 
		   	 Vehicule A300B_2 = new A300B();
		   	 A300B_2.setMoteur(new MoteurElectrique("1500 W", 1234d));
		   	 A300B_2.addOption(new Climatisation());
		   	 A300B_2.addOption(new BarreDeToit());
		   	 A300B_2.addOption(new SiegeChauffant());
		   	 garage.addVoiture(A300B_2);
		   	 
		   	 Vehicule d4_1 = new D4();
		   	 d4_1.setMoteur(new MoteurDiesel("200 Hdi", 25684.80d));
		   	 d4_1.addOption(new BarreDeToit());
		   	 d4_1.addOption(new Climatisation());
		   	 d4_1.addOption(new GPS());
		   	 garage.addVoiture(d4_1);   	 
		   	 
		   	 Vehicule lag2 = new Lagouna();
		   	 lag2.setMoteur(new MoteurDiesel("500 Hdi", 456987d));
		   	 garage.addVoiture(lag2);
		   	 
		   	 Vehicule A300B_1 = new A300B();
		   	 A300B_1.setMoteur(new MoteurHybride("ESSENCE/Electrique", 12345.95d));
		   	 A300B_1.addOption(new VitreElectrique());
		   	 A300B_1.addOption(new BarreDeToit());
		   	 garage.addVoiture(A300B_1);
		   	 
		   	 Vehicule d4_2 = new D4();
		   	 d4_2.setMoteur(new MoteurElectrique("100 KW", 1224d));
		   	 d4_2.addOption(new SiegeChauffant());
		   	 d4_2.addOption(new BarreDeToit());
		   	 d4_2.addOption(new Climatisation());
		   	 d4_2.addOption(new GPS());
		   	 d4_2.addOption(new VitreElectrique());
		   	 garage.addVoiture(d4_2); 

			 save(garage);
		}

		System.out.println(garage);
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
