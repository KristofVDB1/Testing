package domain;

import domain.*;

public class Driehoek extends Vorm {

	private Punt hoekpunt1;
	private Punt hoekpunt2;
	private Punt hoekpunt3;

	public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
		setHoekPunten(hoekpunt1, hoekpunt2, hoekpunt3);
	}

	public void setHoekPunten(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
		if (hoekpunt1 == null || hoekpunt2 == null || hoekpunt3 == null) {
			throw new DomainException("Hoekpunten mogen niet null zijn");
		}
		if ((hoekpunt2.getX()- hoekpunt1.getX())* (hoekpunt3.getY()-hoekpunt1.getY()) == ((hoekpunt3.getX()- hoekpunt1.getX())* (hoekpunt2.getY()-hoekpunt1.getY()))) {
			throw new DomainException ("Punten mogen niet op eenzelfde lijn liggen");
		}
		this.hoekpunt1 = hoekpunt1;
		this.hoekpunt2 = hoekpunt2;
		this.hoekpunt3 = hoekpunt3;
	}

	public Punt getHoekpunt1() {
		return hoekpunt1;
	}

	public Punt getHoekpunt2() {
		return hoekpunt2;
	}

	public Punt getHoekpunt3() {
		return hoekpunt3;
	}

	@Override
	public boolean equals(Object o) {
		boolean resultaat = false;
		if (o instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) o;
			resultaat = this.getHoekpunt1().equals(driehoek.getHoekpunt1())
					&& this.getHoekpunt2().equals(driehoek.getHoekpunt2())
					&& this.getHoekpunt3().equals(driehoek.getHoekpunt3());
		}
		return resultaat;
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + this.hoekpunt1 + "- hoekpunt 2: " + this.hoekpunt2 + "- hoekpunt3: "
				+ this.hoekpunt3;
	}
}
