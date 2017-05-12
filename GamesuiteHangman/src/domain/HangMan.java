package domain;

import db.*;

public class HangMan {
	
	private Speler speler;
	private WoordenLijst woordenlijst;
	private HintWoord woord;
	private TekeningHangMan tekening;

	public HangMan(Speler geldigeSpeler, WoordenLijst geldigeWoordenlijst) {
		setSpeler(geldigeSpeler);
		setWoordenlijst(geldigeWoordenlijst);
		tekening = new TekeningHangMan("HangMan - " + speler.getNaam());
		String w = geldigeWoordenlijst.getRandomWoord();
		woord = new HintWoord(w);
	}

	private void setWoordenlijst(WoordenLijst geldigeWoordenlijst) {
		if(geldigeWoordenlijst == null)
			throw new DomainException("woordenlijst mag niet leeg zijn");
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
			return true;
		}
		return false;
	}

	public boolean isGewonnen() {
		if(woord.isGeraden()){
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
		woord.setWoord(woordenlijst.getRandomWoord());
		tekening.reset();
		
	}

}
