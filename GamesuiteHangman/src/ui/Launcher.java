package ui;

import javax.swing.JOptionPane;
import ui.PictionaryUi;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		final Object[] games = {"Pictionary", "Hangman"};
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		//JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, games, null);
		
		switch((String)keuze){
		case "Pictionary":
			PictionaryUi pictionary = new PictionaryUi();
		case "Hangman":
			HangManUi hangMan = new HangManUi();
			hangMan.play();
		default:
			
		}
		
		

		
	}

}
