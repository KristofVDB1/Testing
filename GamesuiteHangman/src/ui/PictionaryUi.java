package ui;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi {
	
	private Speler speler;
	private Tekening tekening;
	private Object[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk", "Driehoek" };
	
	public PictionaryUi(){
		setSpeler(speler);
		createTekening();
		showMenuTekening();
	}
	
	private void createTekening() {
		String naam = JOptionPane.showInputDialog("Geef de naam van je tekening:");
		
		try {
			tekening = new Tekening(naam);
		}catch(IllegalArgumentException exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage());
		}
	}
	
	private void showMenuTekening() {
		boolean stop = false;
		
		while(!stop) {
			try {
				int keuze = Integer.parseInt(JOptionPane.showInputDialog("Wat wil je doen: \n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen"));
				
				switch(keuze) {
				case 1:
					createShape();
					break;
				case 2:
					GameHoofdScherm view = new GameHoofdScherm(tekening.getNaam(), tekening);
					view.setVisible(true);
					view.teken();
					break;
				case 0:
					stop = true;
					break;
				default:
					stop = true;
				}
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Ongeldige keuze");
			}
		}
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
				Rechthoek rect = new Rechthoek(new Punt(x, y), breedte, hoogte);
				JOptionPane.showMessageDialog(null, rect);
				tekening.voegToe(rect);
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Foute invoer");
				createShape();
			}catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, e);
				createShape();
			}
			break;
		case "Cirkel":
			int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt"));
			int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt"));				
			int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel: "));
			
			try{
				Cirkel cirkel = new Cirkel(new Punt(x, y), radius);
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel);
				tekening.voegToe(cirkel);
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Foute invoer");
				createShape();
			}catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, e);
				createShape();
			}
			
		
			break;
		case "Lijnstuk": 
			
			
			try{
				Punt punt1 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het eerste punt")));
				Punt punt2 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het tweede punt")));
				
				LijnStuk lijnstuk = new LijnStuk (punt1, punt2);
				JOptionPane.showMessageDialog(null, "U heeft het lijnstuk gemaakt: " + lijnstuk.toString());
				tekening.voegToe(lijnstuk);
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Foute invoer");
				createShape();
			}catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, e);
				createShape();
			}
			
			break;
		case "Driehoek": 
			
			try{
				Punt puntDriehoek1 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het eerste punt")));
				Punt puntDriehoek2 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het tweede punt")));
				Punt puntDriehoek3 = new Punt (Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het derde punt: ")), Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het derde punt")));

				Driehoek driehoek = new Driehoek (puntDriehoek1, puntDriehoek2, puntDriehoek3);

				JOptionPane.showMessageDialog(null, driehoek.toString());
				tekening.voegToe(driehoek);
			}catch(NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "Foute invoer");
				createShape();
			}catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, e);
				createShape();
			}
			break;
		default:
			
		}
	}

	public void showMenu(){
		
		
	}
	
}
