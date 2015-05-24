package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;

public class KorisnikTest extends Korisnik{
	long id=1;
	String ime="Dino";
	String prezime="Hurem";
	String jmbg="2311991170041";
	String adresa="Adresa 1";
	String telefon="033/666-999";
	String mail="dino@aef.aa";
	TipKorisnika tip=TipKorisnika.values()[1];
	String username="dino_1";
	String lozinka="admin";
	Korisnik k = new Korisnik(id, ime, prezime, jmbg, adresa,
			telefon, mail, tip, username, lozinka);
	
	
	
	
	@Test
	public void testGetId() {
		long id1;
		id1=k.getId();
		Assert.assertEquals(1, id1);
	}
	
	@Test
	public void testSetId() {
		try {
			
			k.setId(54);
			
			Assert.assertEquals(54, k.getId());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - setId");
		}
	}
	
	@Test
	public void testGetIme() {
		String ime1;
		ime1=k.getIme();
		Assert.assertEquals("Dino", ime1);
	}
	
	@Test
	public void testSetIme() {
		try {
			
			k.setIme("Dino");
			
			Assert.assertEquals("Dino", k.getIme());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - setIme");
		}
	}
	
	@Test
	public void testGetPrezime() {
		String prezime1;
		prezime1=k.getPrezime();
		Assert.assertEquals("Hurem", prezime1);
	}
	
	@Test
	public void testSetPrezime() {
		try {
			
			k.setPrezime("Hurem");
			
			Assert.assertEquals("Hurem", k.getPrezime());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getIme");
		}
	}
	
	@Test
	public void testGetJmbg() {
		String jmbg1;
		jmbg1=k.getJmbg();
		Assert.assertEquals("2311991170041", jmbg1);
	}
	
	@Test
	public void testSetJmbg() {
		try {
			
			k.setJmbg("2311991170041");
			
			Assert.assertEquals("2311991170041", k.getJmbg());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getJmbg");
		}
	}
	
	@Test
	public void testGetAdresa() {
		String adresa1=k.getAdresa();
		
		Assert.assertEquals(adresa, adresa1);
	}
	
	@Test
	public void testSetAdresa() {
		try {
			
			k.setAdresa("Adresa 1");
			
			Assert.assertEquals("Adresa 1", k.getAdresa());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getAdresa");
		}
	}
	
	@Test
	public void testGetTelefon() {
		String telefon1=k.getTelefon();
		
		Assert.assertEquals(telefon, telefon1);
	}
	
	@Test
	public void testSetTelefon() {
		try {
			
			k.setTelefon("033/666-999");
			
			Assert.assertEquals("033/666-999", k.getTelefon());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getTelefon");
		}
	}
	
	@Test
	public void testGetMail() {
		String mail1=k.getMail();
		
		Assert.assertEquals(mail, mail1);
	}
	
	@Test
	public void testSetMail() {
		try {
			
			k.setMail("dino@aef.aa");
			
			Assert.assertEquals("dino@aef.aa", k.getMail());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getMail");
		}
	}
	
	@Test
	public void testGetTip() {
		TipKorisnika tip1=k.getTipKorisnika();
		
		Assert.assertEquals(tip, tip1);
	}
	
	@Test
	public void testSetTip() {
		try {
			
			k.setTipKorisnika(TipKorisnika.values()[1]);
			
			Assert.assertEquals(TipKorisnika.values()[1], k.getTipKorisnika());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getTipKorisnika");
		}
	}
	
	@Test
	public void testGetUsername() {
		String username1=k.getKorisnickoIme();
		
		Assert.assertEquals(username, username1);
	}
	
	@Test
	public void testSetUsername() {
		try {
			
			k.setKorisnickoIme("dino_1");
			
			Assert.assertEquals("dino_1", k.getKorisnickoIme());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getKorisnickoIme");
		}
	}
	
	@Test
	public void testGetLozinka() {
		String pass=k.getLozinka();
		
		Assert.assertEquals(lozinka, pass);
	}
	
	@Test
	public void testSetLozinka() {
		try {
			
			k.setLozinka("admin");
			
			Assert.assertEquals("admin", k.getLozinka());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getLozinka");
		}
	}
	
	@Test
	public void testToTipKorisnika() {		
		
		String tipkor="Administrator";
		Assert.assertEquals(k.ToTipKorisnika(tipkor), k.getTipKorisnika());
	}

	
}
