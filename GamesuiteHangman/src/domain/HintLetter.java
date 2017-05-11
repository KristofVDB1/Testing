package domain;

public class HintLetter {
	private char letter;
	private boolean isGeraden;
	
	public HintLetter(char c) {
		this.letter = c;
		isGeraden = false;
		if(letter == ' ') isGeraden = true;
	}
	
	public boolean raad(char letter){
		if((!isGeraden)&& Character.toLowerCase(letter) == Character.toLowerCase(this.getLetter())){
			isGeraden = true;
			return true;
		}
		return false;
	}
	
	public char toChar(){
		if(letter == ' ') return letter;
		if(isGeraden) return letter; else return '_';
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public boolean isGeraden(){
		return this.isGeraden;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		if(o instanceof HintLetter){
			HintLetter h = (HintLetter)o;
			result = this.getLetter() == h.getLetter();
		}
		return result;
	}

}
