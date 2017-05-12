package ui;

import javax.swing.JOptionPane;

import domain.*;
import db.*;

public class HangManUi {
	private Speler speler;
	private WoordenLijst woordenlijst;
	private HintWoord woord;
	private HangmanPaneel paneel;
	private HangMan spel;
	private HangManHoofdScherm hoofdScherm;
	
	
	public HangManUi(Speler speler, WoordenLijst woordenlijst){
		woord = new HintWoord("bird");
		this.speler = speler;
		
	}

	public Speler getSpeler() {
		return speler;
	}

	public void setSpeler(Speler speler) {
		this.speler = speler;
	}

	public HintWoord getWoord() {
		return woord;
	}

	public void setWoord(HintWoord woord) {
		this.woord = woord;
	}
	
	public void play(){
		/*GameHoofdScherm view = new GameHoofdScherm(tekening.getNaam(), tekening.getTekening());
		view.setVisible(true);
		view.teken();
		String message = "";
		while(!woord.isGeraden()){
			char letter = JOptionPane.showInputDialog(message + "Have you heard about the word?"
					+ "\n"
					+ "\n" + woord
					+ "\n"
					+ "\n" + "geef een letter: ").charAt(0);
			if(woord.raad(letter)){
				message = "goed zo! \n\n";
			}else{
				message = "nej! \n\n";
			}

		}
		JOptionPane.showMessageDialog(null, "Wa-Ha-Hauw! je hebt het woord geraden!");*/
		
		spel = new HangMan(speler, woordenlijst);
		paneel = new HangmanPaneel(spel);
		hoofdScherm = new HangManHoofdScherm(spel, paneel);
		hoofdScherm.start();
		
	}
	
	
}
