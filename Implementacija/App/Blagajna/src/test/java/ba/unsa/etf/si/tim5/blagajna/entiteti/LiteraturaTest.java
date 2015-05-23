package ba.unsa.etf.si.tim5.blagajna.entiteti;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class LiteraturaTest extends TestCase {
	
	Literatura l =  new Literatura(100, "010AAA","Naziv literature", "AUtor lit", 21, 20.00);
	
	@Before
	public void TestnePostavke () {
		
			//l =  new Literatura(100, "010AAA","Naziv literature", "AUtor lit", 21, 20.00);
			
	}
	public void testLiteratura() {
		fail("Not yet implemented"); // TODO
	}

	public void testLiteraturaLongStringStringStringIntDouble() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testGetId() {
		long id_n;
		id_n=l.getId();
		Assert.assertEquals(100, id_n);
	}
	@Test
	public void testSetId() {
		try {
			
			l.setId(101);
			
			Assert.assertEquals(101, l.getId());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test fail - setId");
		}
	}
	@Test
	public void testGetIsbn() {
		String isbn_n;
		isbn_n = l.getIsbn();
		Assert.assertEquals("010AAA", isbn_n);
	}
	@Test
	public void testSetIsbn() {
		try {			
			l.setIsbn("010AAA");			
			Assert.assertEquals("010AAA", l.getIsbn());
		} 		
		catch (Exception e) {
			
			Assert.fail("Test fail - setIsbn");
		}
	}
	@Test
	public void testGetNaziv() {
		String naziv_n;
		naziv_n = l.getNaziv();
		Assert.assertEquals("Naziv literature", naziv_n);
	}
	@Test
	public void testSetNaziv() {
		try {			
			l.setNaziv("Naziv literature");			
			Assert.assertEquals("Naziv literature", l.getNaziv());
		} 		
		catch (Exception e) {
			
			Assert.fail("Test fail - setNaziv");
		}
	}
	@Test
	public void testGetAutor() {
		String autor_n;
		autor_n = l.getAutor();
		Assert.assertEquals("AUtor lit", autor_n);
	}
	@Test
	public void testSetAutor() {
		try {			
			l.setAutor("AUtor lit");			
			Assert.assertEquals("AUtor lit", l.getAutor());
		} 		
		catch (Exception e) {
			
			Assert.fail("Test fail - setAutor");
		}
	}
	@Test
	public void testGetKolicina() {
		int kol;
		kol = l.getKolicina();
		Assert.assertEquals(21, kol);
	}
	@Test
	public void testSetKolicina() {
		try {			
			l.setKolicina(21);			
			Assert.assertEquals(21, l.getKolicina());
		} 		
		catch (Exception e) {
			
			Assert.fail("Test fail - setKolicina");
		}
	}
	@Test
	public void testGetCijena() {
		//double cost;
		//cost= l.getCijena();
		//Assert.assertEquals(20.00,cost);
	}
	@Test
	public void testSetCijena() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testDodajLiteraturu() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testObrisiLiteraturu() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
