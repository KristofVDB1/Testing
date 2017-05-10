package domain;

import java.util.ArrayList;

public class Tekening {
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
			throw new DomainException("Ongeldige naam");
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
		for(Vorm temp : vormen) {
			if(temp.equals(vorm)) {
				vormen.remove(temp);
			}
		}
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
				for(int i = 0; i < vormen.size(); i++) {
					if(!tekening.getVorm(i).getClass().equals(this.getVorm(i).getClass()) || !tekening.getVorm(i).equals(this.getVorm(i))) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
