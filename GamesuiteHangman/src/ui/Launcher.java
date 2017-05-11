package ui;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import ui.PictionaryUi;
import domain.*;

public class Launcher {

	public static void main(String[] args) throws FileNotFoundException {
		final Object[] games = {"Pictionary", "Hangman"};
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		//JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, games, null);
		
		switch((String)keuze){
		case "Pictionary":
			PictionaryUi pictionary = new PictionaryUi();
		case "Hangman":
			WoordenLezer woordenlezer = new WoordenLezer("hangman.txt");
			woordenlezer.lees();
			HangManUi hangMan = new HangManUi();
			hangMan.play();
			
		}
		
		

		
	}

}
