package ui;

import javax.swing.JOptionPane;

import domain.*;

public class HangManUi {
	private Speler speler;
	private HintWoord woord;
	
	public HangManUi(){
		woord = new HintWoord("bird");
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
		JOptionPane.showMessageDialog(null, "Wa-Ha-Hauw! je hebt het woord geraden!");
		
		
	}
	
	
}
