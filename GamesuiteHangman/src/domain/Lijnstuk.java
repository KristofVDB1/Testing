package domain;

public class LijnStuk extends Vorm{
	
	private Punt start;
	private Punt eind;
	
	
	public LijnStuk(Punt start, Punt eind){
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
	
	public Punt getEindPunt() {
		return eind;
	}

	public Punt getStartPunt() {
		return start;
	}
	
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		
		Punt start1 = ((LijnStuk) o).getStartPunt();
		Punt eind1 = ((LijnStuk) o).getEindPunt();
		
		if ((start1.getX() == this.start.getX() && start1.getY() == this.start.getY()) &&
				(eind1.getX() == this.eind.getX() && eind1.getY() == this.eind.getY())){
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Lijnstuk met als startpunt: " + start +" en als eindpunt: " + eind;
	}
	
	
}
