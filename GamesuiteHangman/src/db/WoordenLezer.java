package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoordenLezer {
	private WoordenLijst woordenlijst = new WoordenLijst();
	private String bestandsnaam;
	File woordenlijstFile = new File("hangman.txt");

	public WoordenLezer(String bestandsNaam) {
		this.setBestandsnaam(bestandsNaam);
	}

	public void setBestandsnaam(String bestandsnaam) {
		this.bestandsnaam = bestandsnaam;
	}

	public WoordenLijst lees() throws FileNotFoundException {
		Scanner scannerFile = new Scanner(woordenlijstFile);
		while (scannerFile.hasNextLine()) {
			Scanner scannerLijn = new Scanner(scannerFile.nextLine());
			scannerLijn.useDelimiter("\n");
			String naam = scannerLijn.next();
			woordenlijst.voegToe(naam);
		}
		return woordenlijst;
	}
}