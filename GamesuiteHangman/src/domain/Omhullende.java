package domain;

public class Omhullende {
	private Punt positieLinksBoven;
	private int breedte, hoogte;
	
	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
		setPositieLinksBoven(positieLinksBoven);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	private void setPositieLinksBoven(Punt positieLinksBoven) {
		if(positieLinksBoven == null) {
			throw new DomainException("Ongeldig punt");
		}
		this.positieLinksBoven = positieLinksBoven;
	}

	private void setBreedte(int breedte) {
		if(breedte < 0) {
			throw new DomainException("Breedte moet groter of gelijk aan 0 zijn");
		}
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if(hoogte < 0) {
			throw new DomainException("Hoogte moet groter of gelijk aan zijn");
		}
		this.hoogte = hoogte;
	}
	
	public Punt getLinkerBovenhoek() {
		return positieLinksBoven;
	}
	
	public int getHoogte() {
		return hoogte;
	}
	
	public int getBreedte() {
		return breedte;
	}
	
	public int getMinimumX() {
		return positieLinksBoven.getX();
	}
	
	public int getMinimumY() {
		return positieLinksBoven.getY();
	}
	
	public int getMaximumX() {
		return positieLinksBoven.getX() + breedte;
	}
	
	public int getMaximumY() {
		return positieLinksBoven.getY() + hoogte;
	}
	
	public boolean equals(Object object) {
		if(object == null) return false;
		if(object instanceof Omhullende) {
			Omhullende omhullende = (Omhullende) object;
			if(this.positieLinksBoven.equals(omhullende.positieLinksBoven) && this.breedte == omhullende.breedte && this.hoogte == omhullende.hoogte) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "Omhullende: " + positieLinksBoven + " - " + breedte + " - " + hoogte;
	}
}
