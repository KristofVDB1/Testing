package domain;

public class Punt {
	private int x;
	private int y;
	
	public Punt(int x, int y){
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "(" + x + " , " + y + ")";
	}
	
	public boolean equals(Object o){
		
		if (o instanceof Punt){
			
			Punt p = (Punt) o;
			if (p.getX() == this.x && p.getY() == this.y){
				return true;
			}
		}
		return false;
	}
	
}
