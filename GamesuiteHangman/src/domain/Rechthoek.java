package domain;

public class Rechthoek extends Vorm{
	private int breedte, hoogte;
	Punt linkerbovenhoek;
	
	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte){
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerbovenhoek);
	}

	public Punt getLinkerBovenhoek() {
		return linkerbovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerbovenhoek) {
		if(linkerbovenhoek == null) {
			throw new DomainException("Ongeldige linkerbovenhoek");
		}
		this.linkerbovenhoek = linkerbovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getHoogte() {
		return hoogte;
	}
	
	private void setBreedte(int breedte) {
		if(breedte <= 0) {
			throw new DomainException("Ongeldige breedte");
		}
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if(hoogte <= 0) {
			throw new DomainException("Ongeldige hoogte");
		}
		this.hoogte = hoogte;
	}
	
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(object instanceof Rechthoek){
			Rechthoek rechthoek = (Rechthoek) object;
			if (this.breedte == rechthoek.breedte && this.hoogte == rechthoek.hoogte && linkerbovenhoek.equals(rechthoek.linkerbovenhoek)){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return "Rechthoek: positie: " + linkerbovenhoek + " - breedte: " + this.breedte + " - hoogte: " + hoogte + "\n" + getOmhullende();
	}

	public Omhullende getOmhullende() {
		return new Omhullende(linkerbovenhoek, breedte, hoogte);
	}
}
