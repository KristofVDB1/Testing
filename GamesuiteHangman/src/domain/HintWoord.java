package domain;

import java.util.ArrayList;

public class HintWoord {
	ArrayList<HintLetter> letters;
	String woord;

	public HintWoord(String woord) {
		setWoord(woord);
		
	}
	
	public void setWoord(String woord){
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("Het woord mag niet leeg zijn");
		}
		this.woord = woord;
		letters = new ArrayList<>();
		for(char c : woord.toCharArray()){
			letters.add(new HintLetter(c));
		}
	}

	public boolean isGeraden() {
		boolean result = true;
		for(HintLetter h: letters){
			result = result && h.isGeraden();
		}
		return result;
	}
	
	public String getWoord(){
		return this.woord;
	}

	public boolean raad(char letter) {
		boolean result = false;
		for(HintLetter l: letters){
			if(l.raad(letter)){
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i<letters.size(); i++){
			result += letters.get(i).toChar();
			//spaties toevoegen tussen letters
			if(i<letters.size()-1) result += " ";
		}
		return result;
	}

}
