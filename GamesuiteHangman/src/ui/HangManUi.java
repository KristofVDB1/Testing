package ui;

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
		this.woordenlijst = woordenlijst;
		
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
		
		
		spel = new HangMan(speler, woordenlijst);
		paneel = new HangmanPaneel(spel);
		hoofdScherm = new HangManHoofdScherm(spel, paneel);
		hoofdScherm.start();
		
	}
	
	
}
