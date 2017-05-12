package domain;

import db.*;

public class HangMan {
	
	Speler speler;
	WoordenLijst woordenlijst;
	boolean gameOver = false;
	HintWoord woord;
	TekeningHangMan tekening;

	public HangMan(Speler geldigeSpeler, WoordenLijst geldigeWoordenlijst) {
		setSpeler(geldigeSpeler);
		setWoordenlijst(geldigeWoordenlijst);
		tekening = new TekeningHangMan("HangMan - " + speler.getNaam());
		String w = geldigeWoordenlijst.getRandomWoord();
		woord = new HintWoord(w);
	}

	private void setWoordenlijst(WoordenLijst geldigeWoordenlijst) {
		this.woordenlijst = geldigeWoordenlijst;
		
	}

	private void setSpeler(Speler geldigeSpeler) {
		if(geldigeSpeler == null)
			throw new DomainException("Speler mag niet leeg zijn");
		this.speler = geldigeSpeler;
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
	
	public void reset(){
		
		tekening.reset();
		woord.setWoord(woordenlijst.getRandomWoord());
	}

}
