package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	private Punt middelpunt1 = new Punt(200, 200);
	private Punt zelfdemiddelpunt1 = new Punt(200,200);
	private Punt middelpunt2 = new Punt(300, 300);
	private int radius1 = 20;
	private int radius2 = 20;

	@Test
	public void Werkt_De_Constructor_Correct() {
		Cirkel cirkel = new Cirkel(middelpunt1, 20);

		assertEquals(middelpunt1, cirkel.getMiddelpunt());
		assertEquals(radius, cirkel.getRadius());
	}

	@Test(expected = DomainException.class)
	public void Cirkel_met_ongeldig_middelpunt_gooit_exception() {
		Cirkel cirkel = new Cirkel(null , 20);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_met_negatieve_straal_gooit_exception() {
		Cirkel cirkel = new Cirkel(middelpunt1 , -5);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_met_straal_gelijk_aan_nul_gooit_exception() {
		Cirkel cirkel = new Cirkel(middelpunt1 , 0);
	}
	
	@Test 
	public void Twee_dezelfde_cirkels_zijn_gelijk () {
		Cirkel cirkel1 = new Cirkel (middelpunt1, radius1);
		Cirkel cirkel2 = new Cirkel (zelfdemiddelpunt1, radius2);
		assertTrue(cirkel1.equals(cirkel2));
	}
	
	@Test 
	public void Tweede_cirkel_met_waarde_null_geeft_false () {
		Cirkel cirkel1 = new Cirkel (middelpunt1, radius1);
		assertFalse(cirkel1.equals(null));
	}
	
	@Test 
	public void Twee_cirkels_met_verschillend_middelpunt_geeft_false () {
		Cirkel cirkel1 = new Cirkel (middelpunt1, radius1);
		Cirkel cirkel2 = new Cirkel (middelpunt2, radius2);
		assertFalse(cirkel1.equals(cirkel2));
	}
	
	@Test 
	public void Twee_cirkels_met_verschillende_straal_geeft_false () {
		Cirkel cirkel1 = new Cirkel (middelpunt1, radius1);
		Cirkel cirkel2 = new Cirkel (zelfdemiddelpunt1, 3*radius2);
		assertFalse(cirkel1.equals(cirkel2));
	}
	
	
	
}
