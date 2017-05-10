package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	
	private Speler speler;
	private Object[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk", "Driehoek" };
	
	
	
	public PictionaryUi(){
		//setSpeler(speler);
		createShape();
	}
	
	
	public void setSpeler(Speler speler) {
		this.speler = speler;
	}
	
	private void createShape(){
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		switch((String) keuze) {
		case "Rechthoek":
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
		case "Cirkel":
			int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt"));
			int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt"));				
			
			Punt punt = new Punt(x, y);
			
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
			
			int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel: "));
			
			Cirkel cirkel = new Cirkel(punt, radius);
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel);
		
			
		case "Lijnstuk": 
			
			Punt punt1 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het eerste punt")));
			Punt punt2 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het tweede punt")));

			LijnStuk lijnstuk = new LijnStuk (punt1, punt2);
			
			JOptionPane.showMessageDialog(null, "U heeft het lijnstuk gemaakt: " + lijnstuk.toString());
			
		case "Driehoek": 
			Punt puntDriehoek1 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het eerste punt")));
			Punt puntDriehoek2 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het tweede punt")));
			Punt puntDriehoek3 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het derde punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het derde punt")));
			
			Driehoek driehoek = new Driehoek (puntDriehoek1, puntDriehoek2, puntDriehoek3);
			
			JOptionPane.showMessageDialog(null, driehoek.toString());
		
		default:
			
		}
	}

	public void showMenu(){
		
		
	}
	
}
