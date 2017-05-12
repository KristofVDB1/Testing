package domain;

import db.*;

public class HangMan {
	
	Speler speler;
	WoordenLijst woordenlijst;
	boolean gameOver = false;
	HintWoord woord;
	TekeningHangMan tekening;

	public HangMan(Speler geldigeSpeler, WoordenLijst geldigeWoordenlijst) {
		this.speler = geldigeSpeler;
		this.woordenlijst = geldigeWoordenlijst;
		tekening = new TekeningHangMan("HangMan - " + speler.getNaam());
		woord = new HintWoord("programmeren");
	}

	public Speler getSpeler() {
		return this.speler;
	}

	public boolean isGameOver() {
		if(tekening.getAantalOnzichtbaar()==0){
			//woord.setWoord(woordenlijst.getRandomWoord());
			return true;
		}
		return false;
	}

	public boolean isGewonnen() {
		if(woord.isGeraden()){
			//woord.setWoord(woordenlijst.getRandomWoord());
			return true;
			
		}
		return false;
	}

	public String getHint() {
		return woord.toString();
	}

	public TekeningHangMan getTekening() {
		return tekening;
	}

	public void raad(char letter) {
		boolean geraden = false;
		
		geraden = woord.raad(letter);
		if(!geraden){
			tekening.zetVolgendeZichtbaar();
		}
		
	}

}
