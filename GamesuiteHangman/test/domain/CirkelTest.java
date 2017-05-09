package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	private Punt middelpunt1 = new Punt(200,200);
	private Punt middelpunt2 = new Punt(300,300);
	private int radius = 20;
	
	
	@Test
	public void Werkt_De_Constructor_Correct () {
		Cirkel cirkel = new Cirkel (middelpunt1, 20);
		
		assertEquals(middelpunt1, cirkel.getMiddelpunt());
		assertEquals(radius, cirkel.getRadius());
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_met_ongeldig_middelpunt_gooit_exception () {
		
	}
}
