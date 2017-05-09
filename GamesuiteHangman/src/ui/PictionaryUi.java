package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	
	private Speler speler;
	
	
	
	public PictionaryUi(){
		//setSpeler(speler);
	}
	
	
	public void setSpeler(Speler speler) {
		this.speler = speler;
	}

	
	
	public void showMenu(){
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt"));
			
		
		Punt punt = new Punt(x, y);
		
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel: "));
		
		Cirkel cirkel = new Cirkel(punt, radius);
		
		JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel);
		
	}
	
}
