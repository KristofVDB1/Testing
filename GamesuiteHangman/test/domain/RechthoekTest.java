package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RechthoekTest {

	private Punt linkerBovenhoek;
	private int breedte, hoogte;
	private Rechthoek rechthoek;
	private Omhullende omhullende;

	@Before
	public void setUp() {
		linkerBovenhoek = new Punt(200, 200);
		breedte = 20;
		hoogte = 40;
		omhullende = new Omhullende(linkerBovenhoek, breedte, hoogte);
		rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte, omhullende);
	}

	@Test
	public void Rechthoek_moet_rechthoek_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() {
		Rechthoek rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte, omhullende);
		assertEquals(linkerBovenhoek, rechthoek.getLinkerBovenhoek());
		assertEquals(hoogte, rechthoek.getHoogte());
		assertEquals(breedte, rechthoek.getBreedte());
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_linkerbovenhoek_null()  {
		new Rechthoek(null, breedte, hoogte, omhullende);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_kleiner_dan_0()  {
		new Rechthoek(linkerBovenhoek, -1, hoogte, omhullende);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_kleiner_dan_0()  {
		new Rechthoek(linkerBovenhoek, breedte, -1, omhullende);
		
	}

	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_gelijk_aan_0()  {
		new Rechthoek(linkerBovenhoek, 0, hoogte, omhullende);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_gelijk_aan_dan_0()  {
		new Rechthoek(linkerBovenhoek, breedte, 0, omhullende);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn(){
		Rechthoek zelfdeRechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte, omhullende);
		assertTrue(rechthoek.equals(zelfdeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt(){
		Punt andereLinkerBovenhoek = new Punt(100,100);
		Rechthoek verschillendeRechthoek = new Rechthoek(andereLinkerBovenhoek, breedte, hoogte, omhullende);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_breedte_verschilt(){
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte + 10, hoogte, omhullende);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoogte_verschilt(){
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte, hoogte + 10, omhullende);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	public void getOmhullende_geeft_juiste_omhullende() {
		assertEquals(new Omhullende(rechthoek.getLinkerBovenhoek(), rechthoek.getBreedte(), rechthoek.getHoogte()), rechthoek.getOmhullende());
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(rechthoek.equals(null));
	}
}
