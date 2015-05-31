package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;

public class StudentTest extends Student {
	
	long id = 1; 
	String ime = "Aida";
	String prezime = "Grosic";
	String jmbg = "1105992115009";
	String mail = "sgrosic1@etf.unsa.ba";
	String adresa = "Sarajevo";
	String opcina = "Novo Sarajevo";
	String telefon = "061/970-280";
	int indeks = 16049;
	double troskoviSkolarine = 1000;
	double troskoviLiterature = 0;
	String imeRoditelja = "Cazim";
	String mjestoRodjenja = "Bihac";
	String opcinaRodjenja = "Bihac";
	String drzavaRodjenja = "BiH";
	double popust = 10;
	GodinaStudija godinaStudija = GodinaStudija.Cetvrta_BSC;
	long dugId = 0;
	
	Student s = new Student(id, ime, prezime, jmbg,
			mail,  adresa,  opcina,  telefon,
			 indeks,  troskoviSkolarine,  imeRoditelja,
			 mjestoRodjenja,  opcinaRodjenja,
			 drzavaRodjenja,  popust,  godinaStudija); 
  
	@Test
	public void testGetId() {
		Assert.assertEquals(1, s.getId());
	}
	
	@Test
	public void testGetIme() {		
		Assert.assertEquals("Aida", s.getIme());
	}
	
	@Test
	public void testGetPrezime() {
		Assert.assertEquals("Grosic", s.getPrezime());
	}
	
	
    @Test 
    public void testGetJmbg() {
     Assert.assertEquals("1105992115009", s.getJmbg());
    }
	
    
    @Test
    public void testGetOpcina() {
    	Assert.assertEquals("Novo Sarajevo", s.getOpcina());
    	
    }
    
    @Test
    public void testGetOpcinaRodjenja() {
    	Assert.assertEquals("Bihac", s.getOpcinaRodjenja());
    }
    
    
    @Test 
    public void testGetMjestoRodjenja() {
    	Assert.assertEquals("Bihac", s.getMjestoRodjenja()); 
    }
	
    @Test 
    public void testGetDrzavaRodjenja(){
    	 Assert.assertEquals("BiH", s.getDrzavaRodjenja());
    }
    
    @Test
    public void testGetIndeks(){
    	Assert.assertEquals(16049, s.getIndeks());
    }
    
    @Test
    public void testGetGodinaStudija(){
    	Assert.assertEquals(GodinaStudija.Cetvrta_BSC, s.getGodinaStudija());
    }
    
    @Test 
    public void testGetMail(){
    	Assert.assertEquals("sgrosic1@etf.unsa.ba", s.getMail());
    }
    
    @Test
    public void testGetTelefon(){
    	Assert.assertEquals("061/970-280", s.getTelefon());
    }
    
    @Test
    public void testGetImeRoditelja(){
    	Assert.assertEquals("Cazim", s.getImeRoditelja());
    }
    
    @Test
	public void testSetMail() {
		try {
			
			s.setMail("sgrosic1@etf.unsa.ba");
			
			Assert.assertEquals("sgrosic1@etf.unsa.ba", s.getMail());
		} 
		
		catch (Exception e) {
			
			Assert.fail("Test failed - getMail");
		}
	}
    
    
    @Test
   	public void testSetIme() {
   		try {
   			
   			s.setIme("Aida");
   			
   			Assert.assertEquals("Aida", s.getIme());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getIme");
   		}
   	}
    
    @Test
   	public void testSetPrezime() {
   		try {
   			
   			s.setIme("Grosic");
   			
   			Assert.assertEquals("Grosic", s.getPrezime());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getPrezime");
   		}
   	}
    
    
    @Test
   	public void testSetOpcina() {
   		try {
   			
   			s.setOpcina("Novo Sarajevo");
   			
   			Assert.assertEquals("Novo Sarajevo", s.getOpcina());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getOpcina");
   		}
   	}
    
    @Test 
    public void testSetTelefon(){
    	try{
    	
    		s.setTelefon("061/970-280"); 
    		Assert.assertEquals("061/970-280", s.getTelefon());
    	}
    	catch(Exception e){
    		
    		Assert.fail("Test failed - getTelefon");
    	}
    }
    
    @Test
   	public void testSetImeRoditelja() {
   		try {
   			
   			s.setImeRoditelja("Cazim");
   			
   			Assert.assertEquals("Cazim", s.getImeRoditelja());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getImeRoditelja");
   		}
   	}
    
    @Test
   	public void testSetIndeks() {
   		try {
   			
   			s.setIndeks(16049);
   			
   			Assert.assertEquals(16049,s.getIndeks());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getIndeks");
   		}
   	}
    
    @Test
   	public void testSetDrzavaRodjenja() {
   		try {
   			
   			s.setDrzavaRodjenja("BiH");
   			
   			Assert.assertEquals("BiH", s.getDrzavaRodjenja());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getDrzavaRodjenja");
   		}
   	}
    
    @Test
   	public void testSetAdresa() {
   		try {
   			
   			s.setAdresa("Sarajevo");
   			
   			Assert.assertEquals("Sarajevo", s.getAdresa());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getAdresa");
   		}
   	}
    
    
    @Test
   	public void testSetJmbg() {
   		try {
   			
   			s.setJmbg("1105992115009");
   			
   			Assert.assertEquals("1105992115009" , s.getJmbg());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getJmbg");
   		}
   	}
    
    
    @Test
   	public void testSetOpcinaRodjenja() {
   		try {
   			
   			s.setOpcinaRodjenja("Bihac");
   			
   			Assert.assertEquals("Bihac" , s.getOpcinaRodjenja());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getOpcinaRodjenja");
   		}
   	}
    
    @Test
   	public void testSetMjestoRodjenja() {
   		try {
   			
   			s.setMjestoRodjenja("Bihac");
   			
   			Assert.assertEquals("Bihac" , s.getMjestoRodjenja());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getMjestoRodjenja");
   		}
   	}
   	
}