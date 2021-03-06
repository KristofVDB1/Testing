package domain;

import java.awt.Graphics;

public class TekeningHangMan {
	String naam;
	Tekening tekening;
	
	public TekeningHangMan(String naam) {
		setNaam(naam);
		tekening = new Tekening(naam);
		
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//�
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		
		tekening.voegToe(galgBodem);
		tekening.voegToe(galgStaaf);
		tekening.voegToe(hangbar);
		tekening.voegToe(koord);
		tekening.voegToe(hoofd);
		tekening.voegToe(oogLinks);
		tekening.voegToe(oogRechts);
		tekening.voegToe(neus);
		tekening.voegToe(mond);
		tekening.voegToe(lijf);
		tekening.voegToe(beenLinks);
		tekening.voegToe(beenRechts);
		tekening.voegToe(voetLinks);
		tekening.voegToe(voetRechts);
		tekening.voegToe(armLinks);
		tekening.voegToe(armRechts);
		tekening.voegToe(handLinks);
		tekening.voegToe(handRechts);
		
		for(int i = 4; i < 18; i++) {
			tekening.getVorm(i).setZichtbaar(false);
		}
	}
	
	private void setNaam(String naam) {
		if(naam == null || naam.trim().equals("")) {
			throw new IllegalArgumentException("Ongeldige naam");
		}
		this.naam = naam;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public Tekening getTekening() {
		return tekening;
	}
	
	public int getAantalOnzichtbaar() {
		int result = 0;
		for(Vorm vorm : tekening.getVormen()) {
			if(!vorm.isZichtbaar()) result++;
		}
		return result;
	}
	
	public void zetVolgendeZichtbaar() {
		for(Vorm vorm : tekening.getVormen()){
			if(!vorm.isZichtbaar()){
				vorm.setZichtbaar(true);
				return;
			}
		}
		throw new DomainException("Alles zichtbaar");
	}
	
	public void reset() {
		for(int i = 4; i < 18; i++) {
			tekening.getVorm(i).setZichtbaar(false);
		}
	}
	
	public void teken(Graphics graphics) {
		tekening.teken(graphics);
	}
	
	public void verwijder() {
		throw new DomainException("");
	}
	
	public void voegToe(Vorm vorm) {
		throw new DomainException("");
	}
}
