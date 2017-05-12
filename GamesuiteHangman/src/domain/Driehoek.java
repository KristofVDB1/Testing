package domain;

import java.awt.Graphics;

public class Driehoek extends Vorm implements Drawable {

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
	
	public int getHoogsteX () {
		int hoogsteX = 0;

		if (this.hoekpunt1.getX() >this.hoekpunt2.getX() && this.hoekpunt1.getX() > this.hoekpunt3.getX()) {
			hoogsteX = this.hoekpunt1.getX();
		}
		else if (this.hoekpunt2.getX() >this.hoekpunt1.getX() && this.hoekpunt2.getX() > this.hoekpunt3.getX()) {
			hoogsteX = this.hoekpunt2.getX();
		}
		else {
			hoogsteX = this.hoekpunt3.getX();
		}
		return hoogsteX;
	}
	
	public int getHoogsteY () {
		int hoogsteY = 0;

		if (this.hoekpunt1.getY() >this.hoekpunt2.getY() && this.hoekpunt1.getY() > this.hoekpunt3.getY()) {
			hoogsteY = this.hoekpunt1.getY();
		}
		else if (this.hoekpunt2.getY() >this.hoekpunt1.getY() && this.hoekpunt2.getY() > this.hoekpunt3.getY()) {
			hoogsteY = this.hoekpunt2.getY();
		}
		else {
			hoogsteY = this.hoekpunt3.getY();
		}
		return hoogsteY;
	}
	
	public int getLaagsteX () {
		int laagsteX = 0;

		if (this.hoekpunt1.getX() <this.hoekpunt2.getX() && this.hoekpunt1.getX() < this.hoekpunt3.getX()) {
			laagsteX = this.hoekpunt1.getX();
		}
		else if (this.hoekpunt2.getX() <this.hoekpunt1.getX() && this.hoekpunt2.getX() < this.hoekpunt3.getX()) {
			laagsteX = this.hoekpunt2.getX();
		}
		else {
			laagsteX = this.hoekpunt3.getX();
		}
		return laagsteX;
	}
	
	public int getLaagsteY () {
		int laagsteY = 0;

		if (this.hoekpunt1.getX() <this.hoekpunt2.getX() && this.hoekpunt1.getX() < this.hoekpunt3.getX()) {
			laagsteY = this.hoekpunt1.getX();
		}
		else if (this.hoekpunt2.getX() <this.hoekpunt1.getX() && this.hoekpunt2.getX() < this.hoekpunt3.getX()) {
			laagsteY = this.hoekpunt2.getX();
		}
		else {
			laagsteY = this.hoekpunt3.getX();
		}
		return laagsteY;
	}
	
	public Omhullende getOmhullende() {
		Punt beginpunt = new Punt(this.getLaagsteX(), this.getLaagsteY());
		return new Omhullende (beginpunt, this.getHoogsteX()-this.getLaagsteX() , this.getHoogsteY()- this.getLaagsteY());
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

	@Override
	public void teken(Graphics graphics) {
		int[] xPoints = { this.getHoekpunt1().getX(), this.getHoekpunt2().getX(),
				this.getHoekpunt3().getX() };
		int[] yPoints = { this.getHoekpunt1().getY(), this.getHoekpunt2().getY(),
				this.getHoekpunt3().getY() };
		graphics.drawPolygon(xPoints, yPoints, 3);
		
	}
}
