package domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import domain.*;
public class WoordenLijst {
	private ArrayList<String> geldigeWoorden;
	File woordenlijstFile = new File("hangman.txt");
    private Random randomGenerator;


	public WoordenLijst() {
		
	}
	
	public int getAantalWoorden() {
		int aantalwoorden = 0;
		return aantalwoorden;
	}
	
	public void voegToe(String woord) {
		geldigeWoorden.add(woord);
	}
	
	public String getRandomWoord () {
		int randomNumber = 0;
		randomNumber = randomGenerator.nextInt(geldigeWoorden.size());
		return geldigeWoorden.get(randomNumber);
	}
}

