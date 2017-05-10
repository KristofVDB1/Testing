package domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Tekening implements Drawable {
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_y = 399;
	private String naam;
	
	private ArrayList<Vorm> vormen;
	
	public Tekening(String naam) {
		setNaam(naam);
		vormen = new ArrayList<Vorm>();
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
	
	public void voegToe(Vorm vorm) {
		if(vorm == null) {
			throw new DomainException("Ongeldige vorm");
		}
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index) {
		if(index < 0 || index > vormen.size()-1) {
			throw new DomainException("Ongeldige index");
		}
		return vormen.get(index);
	}
	
	public int getAantalVormen() {
		return vormen.size();
	}
	
	public void verwijder(Vorm vorm) {
		if(vorm == null) {
			throw new DomainException("Ongeldige vorm");
		}
		vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm) {
		for(Vorm temp : vormen) {
			if(vorm.getClass() == temp.getClass()) {
				if(vorm.equals(temp)) return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String info = "Tekening met naam " + naam + " bestaat uit " + vormen.size() + " vormen: \n";
		for(Vorm vorm : vormen) {
			info += vorm + "\n";
		}
		return info;
	}
	
	public boolean equals(Object object) {
		if(object instanceof Tekening) {
			Tekening tekening = (Tekening) object;
			if(tekening.getAantalVormen() == this.getAantalVormen()) {
				int count = 0;
				for(int i = 0; i < vormen.size(); i++) {
					for(int j = 0; j < vormen.size(); j++) {
						if(this.getVorm(i).getClass().equals(tekening.getVorm(j).getClass()) && this.getVorm(i).equals(tekening.getVorm(j))) {
							count++;
						}
					}
				}
				if(count != this.getAantalVormen()) return false;
				return true;
			}
		}
		return false;
	}

	@Override
	public void teken(Graphics graphics) {
		for(Vorm v: this.vormen){
			v.teken(graphics);
		}
		
	}
}
