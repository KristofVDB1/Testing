package domain;

public class HintLetter {
	char letter;
	boolean isGeraden;
	
	public HintLetter(char c) {
		this.letter = c;
		isGeraden = false;
	}
	
	public boolean raad(char letter){
		if(!isGeraden && Character.toLowerCase(letter) == Character.toLowerCase(this.letter)){
			isGeraden = true;
			return true;
		}
		return false;
	}
	
	public char toChar(){
		if(isGeraden) return letter; else return '_';
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public boolean isGeraden(){
		return this.isGeraden;
	}

}
