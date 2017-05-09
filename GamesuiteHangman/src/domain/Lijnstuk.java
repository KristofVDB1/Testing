package domain;

public class Lijnstuk {
	
	private Punt start;
	private Punt eind;
	
	
	public Lijnstuk(Punt start, Punt eind){
		setStartEnEindPunt(start, eind);
		
	}

	public void setStartEnEindPunt(Punt start, Punt eind) {
		if (start != null && eind != null && start != eind){
			this.start = start;
			this.eind = eind;
		}else{
			throw new DomainException("Ongeldige punten");
		}
		
	}
	
	public Punt getEind() {
		return eind;
	}

	public Punt getStart() {
		return start;
	}
	
	public boolean equals(Object o) {
		
		Punt start1 = ((Lijnstuk) o).getStart();
		Punt eind1 = ((Lijnstuk) o).getEind();
		
		if ((start1.getX() == this.start.getX() && start1.getY() == this.start.getY()) &&
				(eind1.getX() == this.eind.getX() && eind1.getY() == this.eind.getY())){
				return true;
		}
		return false;
	}
	
	
}
