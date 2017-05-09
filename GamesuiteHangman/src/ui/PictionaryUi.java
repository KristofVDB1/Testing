package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class PictionaryUi {
	
	private Speler speler;
	
	
	
	public PictionaryUi(){
		//setSpeler(speler);
	}
	
	
	public void setSpeler(Speler speler) {
		this.speler = speler;
	}

	
	
	public void showMenu(){
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coördinaat van het punt"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coördinaat van het punt"));
			
		
		Punt punt = new Punt(x, y);
		
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
	}
	
}
