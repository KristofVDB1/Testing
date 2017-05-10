package domain;

import domain.*;

public class Cirkel extends Vorm{
	private int radius;
	private Punt middelpunt;
	
	public Cirkel( Punt middelpunt, int radius) {
		setRadius(radius);
		setMiddelpunt(middelpunt);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if(radius <=0)
			throw new DomainException( "radius moet strikt positief zijn");
		this.radius = radius;
	}

	public Punt getMiddelpunt() {
		return middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null)
			throw new DomainException("Geef aub een geldig middelpunt mee");
		this.middelpunt = middelpunt;
	}
	
	public Punt berekenOmhullendeMiddelpunt() {
		Punt MP = new Punt((middelpunt.getX()-radius), (middelpunt.getY()-radius));
		return MP;
	}
	
	public Omhullende getOmhullende () {
		return new Omhullende (this.berekenOmhullendeMiddelpunt(), radius*2, radius*2);
	}
		
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		
		if(o instanceof Cirkel){
			Cirkel cirkel = (Cirkel) o;
			result = this.getMiddelpunt().equals(cirkel.getMiddelpunt()) && this.getRadius() == cirkel.getRadius();
		}
		return result;
	
	}
	
	@Override
	public String toString(){
		return "cirkel:  middelpunt: " + this.getMiddelpunt() + " - straal: "  + this.getRadius();
	}
	
	
}
