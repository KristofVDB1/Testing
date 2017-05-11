package domain;

public class Woord {
	private String naam;

	public Woord(String naam) {
		this.setNaam(naam);
	}

	public void setNaam(String naam) {
		if(naam == null || naam.isEmpty()){
			throw new IllegalArgumentException("geef een correcte naam op");
		}
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}
	
}
