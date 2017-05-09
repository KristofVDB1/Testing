package domain;

public class Speler {
	private String naam;
	private int score;
	
	public Speler(String naam){
	//	super();
		this.setNaam(naam);
		this.score = 0;
	}
	
	public void setNaam(String naam) {
		if(naam == null || naam.isEmpty()){
			throw new DomainException("ongeldige naam");
		}
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addToScore(int score){
		
		if(this.score + score < 0){
			throw new DomainException("score wordt negatief");
		}
		this.score = this.score + score;
	}
	
	public boolean equals(Speler speler){
		if (speler == null){
			return false;
		}
		if(this.naam != speler.getNaam() || this.score != speler.getScore()){
			return false;
		}
		else{
			return true;
		}
	}
	
	@Override
	public String toString(){
		return "naam: " + getNaam() + " score: " + getScore();
	}
	
	
}
