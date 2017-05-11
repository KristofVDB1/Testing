package domain;

public abstract class Vorm implements Drawable {
	
	protected boolean zichtbaar = true;
	
	public abstract Omhullende getOmhullende();
	
	public abstract boolean equals (Object o);

	public abstract String toString();
	
	public boolean isZichtbaar() {
		return zichtbaar;
	}
	
	public void setZichtbaar(boolean set) {
		zichtbaar = set;
	}
}
