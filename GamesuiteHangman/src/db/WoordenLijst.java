package db;

import java.util.ArrayList;
import java.util.Random;


public class WoordenLijst {
	
    private Random randomGenerator = new Random();
	private ArrayList<String> geldigeWoorden = new ArrayList<>();

	public WoordenLijst() {
		
	}
	
	public int getAantalWoorden() {
		int aantalwoorden = 0;
		aantalwoorden = geldigeWoorden.size();
		return aantalwoorden;
	}
	
	public void voegToe(String naam) {
		if (naam == "") {
			throw new DbException("woord mag niet leeg zijn");
		}
		if (naam == null) {
			throw new DbException("Woord mag niet null zijn");
		}
		
		for (int i = 0; i <geldigeWoorden.size(); i++) {
			if (naam == geldigeWoorden.get(i)) {
				throw new DbException("Woord staat al in de lijst");
			}
		}
		geldigeWoorden.add(naam);
	}
	
	public String getRandomWoord () {
		int randomNumber = 0;
		randomNumber = randomGenerator.nextInt(geldigeWoorden.size());
		return geldigeWoorden.get(randomNumber);
	}
	
	@Override
	public String toString(){
		String res = "";
		for(String w: geldigeWoorden){
			res += w + "\n";
		}
		return res;
	}
	
}
