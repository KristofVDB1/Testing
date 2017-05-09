package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	
	private Speler speler;
	private Object[] shapes = {"Cirkel", "Rechthoek"};
	
	
	
	public PictionaryUi(){
		//setSpeler(speler);
	}
	
	
	public void setSpeler(Speler speler) {
		this.speler = speler;
	}
	
	private void createShape(){
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		
		
		if(keuze instanceof Rechthoek){
			String xString = JOptionPane.showInputDialog("x van de rechthoek:");
			String yString = JOptionPane.showInputDialog("y van de rechthoek:");
			String breedteString = JOptionPane.showInputDialog("Breedte van de rechthoek:");
			String hoogteString= JOptionPane.showInputDialog("Breedte van de rechthoek");
			
			try {
				int x = Integer.parseInt(xString);
				int y = Integer.parseInt(yString);
				int breedte = Integer.parseInt(breedteString);
				int hoogte = Integer.parseInt(hoogteString);
				
				JOptionPane.showMessageDialog(null, new Rechthoek(new Punt(x, y), breedte, hoogte));
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Foute invoer");
				createShape();
			}
		}
		
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
