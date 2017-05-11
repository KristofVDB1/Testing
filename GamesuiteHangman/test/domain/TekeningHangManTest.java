package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TekeningHangManTest {
	TekeningHangMan tekeningHangman;
	Tekening tekening;
	String naam = "naam";
	
	@Before
	public void setUp() {
		tekeningHangman = new TekeningHangMan(naam);
		tekening = tekeningHangman.getTekening();
	}

	@Test
	public void afbeeldingHangman_maakt_hangman_met_naam_hangman_en_met_18_vormen_waarvan_14_onzichtbaar() {
		
		assertEquals(18, tekening.getAantalVormen());
		assertEquals(14, tekeningHangman.getAantalOnzichtbaar());
	}
	
	@Test
	public void zetVolgendeZichtbaar_moet_eerstevolgende_onzichtbare_vorm_zichtbaar_zetten() {
		assertFalse(tekening.getVorm(4).isZichtbaar());
		tekeningHangman.zetVolgendeZichtbaar();
		assertTrue(tekening.getVorm(4).isZichtbaar());
		assertFalse(tekening.getVorm(5).isZichtbaar());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void zetVolgendeZichtbaar_gooit_exception_als_alle_zichtbaar() {
		for(int i = 0; i < 18; i++) {
			tekeningHangman.zetVolgendeZichtbaar();
		}
	}
	
	@Test 
	public void reset_moet_alle_vormen_behalve_de_galg_weer_onzichtbaar_zetten() {
		tekeningHangman.zetVolgendeZichtbaar();
		tekeningHangman.zetVolgendeZichtbaar();
		tekeningHangman.reset();
		for(int i = 4; i < 18; i++) {
			assertFalse(tekening.getVorm(i).isZichtbaar());
		}
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void voegToe_moet_een_exception_gooien() {
		tekeningHangman.voegToe(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void verwijder_moet_exception_gooien() {
		tekeningHangman.verwijder();
	}
}
