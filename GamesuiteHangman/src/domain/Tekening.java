package domain;

public class Tekening {
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_y = 399;
	private String naam;
	
	public Tekening(String naam) {
		setNaam(naam);
	}

	private void setNaam(String naam) {
		if(this.naam == null) {
			throw new DomainException("Ongeldige naam");
		}
		this.naam = naam;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public void voegToe(Vorm vorm) {
		
	}
	
	
}
