package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;

public class StudentTest extends Student {
	long id=1;
	String ime="Azra";
	String prezime="Jarebica";
	String adresa="Skenderija";
	String drzavaRodjenja="BiH";
	long dug=2;
	int godinaStudija=3;
	String imeRoditelja="Aida";
	int indeks=16190;
	String jmbg="3110992175020";
	String mail="ajarebica1@etf.unsa.ba";
	String mjestoRodjenja="Sarajevo";
	String opcina="Centar";
	String opcinaRodjenja="Centar";
	double popust=10;
	String telefon="061111111";
	double troskoviLit=100;
	double troskoviSko=100;
	Student s=new Student(id,ime,prezime,jmbg,mail,adresa,opcina,telefon,indeks,
			troskoviSko,imeRoditelja,mjestoRodjenja,opcinaRodjenja,
			drzavaRodjenja,popust,godinaStudija);
	
	@Test
	public void testGetId() {
		long id1;
		id1=s.getId();
		Assert.assertEquals(1, id1);
	}
	
	@Test
	public void testSetId() {
		try {
			
			s.setId(14);
			
			Assert.assertEquals(14, s.getId());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - setId");
		}
	}
	
	@Test
	public void testGetIme() {
		String ime1;
		ime1=s.getIme();
		Assert.assertEquals("Azra", ime1);
	}
	
	@Test
	public void testSetIme() {
		try {
			
			s.setIme("Ajla");
			
			Assert.assertEquals("Ajla", s.getIme());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - setIme");
		}
	}
	
	@Test
	public void testGetPrezime() {
		String prezime1;
		prezime1=s.getPrezime();
		Assert.assertEquals("Jarebica", prezime1);
	}
	
	@Test
	public void testSetPrezime() {
		try {
			
			s.setPrezime("Hurem");
			
			Assert.assertEquals("Hurem", s.getPrezime());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getIme");
		}
	}
	
	@Test
	public void testGetJmbg() {
		String jmbg1;
		jmbg1=s.getJmbg();
		Assert.assertEquals("3110992175020", jmbg1);
	}
	
	@Test
	public void testSetJmbg() {
		try {
			
			s.setJmbg("2311991170041");
			
			Assert.assertEquals("2311991170041", s.getJmbg());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getJmbg");
		}
	}
	
	@Test
	public void testGetAdresa() {
		String adresa1=s.getAdresa();
		
		Assert.assertEquals(adresa, adresa1);
	}
	
	@Test
	public void testSetAdresa() {
		try {
			
			s.setAdresa("Adresa 1");
			
			Assert.assertEquals("Adresa 1", s.getAdresa());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getAdresa");
		}
	}
	
	@Test
	public void testGetTelefon() {
		String telefon1=s.getTelefon();
		
		Assert.assertEquals(telefon, telefon1);
	}
	
	@Test
	public void testSetTelefon() {
		try {
			
			s.setTelefon("033/666-999");
			
			Assert.assertEquals("033/666-999", s.getTelefon());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getTelefon");
		}
	}
	
	@Test
	public void testGetMail() {
		String mail1=s.getMail();
		
		Assert.assertEquals(mail, mail1);
	}
	
	@Test
	public void testSetMail() {
		try {
			
			s.setMail("dino@aef.aa");
			
			Assert.assertEquals("dino@aef.aa", s.getMail());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getMail");
		}
	}
	
	@Test
	public void testGetIndeks() {
		int indeks1=s.getIndeks();
		
		Assert.assertEquals(indeks, indeks1);
	}
	
	@Test
	public void testSetIndeks() {
		try {
			
			s.setIndeks(11111);
			
			Assert.assertEquals(111111, s.getIndeks());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getIndeks");
		}
	}
	
	@Test
	public void testGetOpcina() {
		String opcina1=s.getOpcina();
		
		Assert.assertEquals(opcina, opcina1);
	}
	
	@Test
	public void testSetOpcina() {
		try {
			
			s.setOpcina("Centar");
			
			Assert.assertEquals("Centar", s.getOpcina());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getOpcina");
		}
	}
	
	@Test
	public void testGetDrzavaRodjenja() {
		String drzavaR=s.getDrzavaRodjenja();
		
		Assert.assertEquals(drzavaRodjenja, drzavaR);
	}
	
	@Test
	public void testSetDrzavaRodjenja() {
		try {
			
			s.setDrzavaRodjenja("USA");
			
			Assert.assertEquals("USA", s.getDrzavaRodjenja());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getDrzavaRodjenja");
		}
	}
	
	
	@Test
	public void testGetDugId() {
		long dug1=s.getDugId();
		
		Assert.assertEquals(dug, dug1);
	}
	
	@Test
	public void testSetDugId() {
		try {
			
			s.setDugId(3); 
			
			Assert.assertEquals(3, s.getDugId());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getDugId");
		}
	}
	
	@Test
	public void testGetGodinaStudija() {
		int godina=s.getGodinaStudija();
		
		Assert.assertEquals(godinaStudija, godina);
	}
	
	@Test
	public void testSetGodinaStudija() {
		try {
			
			s.setGodinaStudija(2);
			
			Assert.assertEquals(2, s.getGodinaStudija());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getGodinaStudija");
		}
	}
	
	@Test
	public void testGetImeRoditelja() {
		String imeR=s.getImeRoditelja();
		
		Assert.assertEquals(imeRoditelja, imeR);
	}
	
	@Test
	public void testImeRoditelja() {
		try {
			
			s.setImeRoditelja("Lejla");
			
			Assert.assertEquals("Lejla", s.getImeRoditelja());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getImeRoditelja");
		}
	}
	
	
	@Test
	public void testGetMjestoRodjenja() {
		String mjesto=s.getMjestoRodjenja();
		
		Assert.assertEquals(mjestoRodjenja, mjesto);
	}
	
	@Test
	public void testSetMjestoRodjenja() {
		try {
			
			s.setMjestoRodjenja("Tuzla");
			Assert.assertEquals("Tuzla", s.getMjestoRodjenja() );
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getMjestoRodjenja");
		}
	}
	
	
	@Test
	public void testGetOpcinaRodjenja() {
		String opcinaR=s.getOpcinaRodjenja();
		
		Assert.assertEquals("Centar", opcinaR);
	}
	
	@Test
	public void testSetOpcinaRodjenja() {
		try {
			
			s.setOpcinaRodjenja("Novi Grad");
			
			Assert.assertEquals("Novi Grad", s.getOpcinaRodjenja());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getOpcinaRodjenja");
		}
	}
	
	@Test
	public void testGetPopust() {
		double pop=s.getPopust();
		
		Assert.assertEquals(popust, pop);
	}
	
	
	@Test
	public void testSetPopust() {
		try {
			
			s.setPopust(10);
			
			Assert.assertEquals(Math.abs(10),Math.abs(s.getPopust()));
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getIndeks");
		}
	}


	

	@Test
	public void test(){
		fail("Not yet implemented");
	}

}
