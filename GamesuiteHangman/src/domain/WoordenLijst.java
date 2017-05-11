package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import domain.*;
public class WoordenLijst {
	private ArrayList<Woord> geldigeWoorden= new ArrayList<>();
	File woordenlijstFile = new File("hangman.txt");
    private Random randomGenerator;


	public WoordenLijst() {
		
	}
	
	public int getAantalWoorden() {
		int aantalwoorden = 0;
		aantalwoorden = geldigeWoorden.size();
		return aantalwoorden;
	}
	
	public void voegToe(Woord woord) {
		geldigeWoorden.add(woord);
	}
	
	public Woord getRandomWoord () {
		int randomNumber = 0;
		randomNumber = randomGenerator.nextInt(geldigeWoorden.size());
		return geldigeWoorden.get(randomNumber);
	}
	
	public void voegTxtToe() throws FileNotFoundException {
		Scanner scannerFile = new Scanner(woordenlijstFile); 
		while (scannerFile.hasNextLine()) { 
		Scanner scannerLijn = new Scanner(scannerFile.nextLine()); 
		String naam = scannerLijn.next(); 
		Woord woord = new Woord(naam);
		geldigeWoorden.add(woord);
	}
}
}
