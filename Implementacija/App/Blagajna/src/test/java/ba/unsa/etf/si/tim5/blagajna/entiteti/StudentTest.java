package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	int godinaStudija = 3;
	long dugId = 0;
	
	Student s = new Student(id, ime, prezime, jmbg,
			mail,  adresa,  opcina,  telefon,
			 indeks,  troskoviSkolarine,  imeRoditelja,
			 mjestoRodjenja,  opcinaRodjenja,
			 drzavaRodjenja,  popust,  godinaStudija); 
  
	@Test
	public void testGetId() {
		long id1;
		id1=s.getId();
		Assert.assertEquals(1, id1);
	}
	
	@Test
	public void testGetIme() {
		String ime1;
		ime1=s.getIme();
		Assert.assertEquals("Aida", ime1);
	}
	
	@Test
	public void testGetPrezime() {
		String prezime1;
		prezime1=s.getPrezime();
		Assert.assertEquals("Grosic", prezime1);
	}
	
	
    @Test 
    public void testGetJmbg() {
     String jmbg1; 
     jmbg1 = s.getJmbg(); 
     Assert.assertEquals("1105992115009", jmbg1);
    }
	
    
    @Test
    public void testGetOpcina() {
    	String opcina1; 
    	opcina1 = s.getOpcina(); 
    	Assert.assertEquals("Novo Sarajevo", opcina1);
    	
    }
    
    @Test
    public void testGetOpcinaRodjenja() {
    	String opcinaRod1; 
    	opcinaRod1 = s.getOpcinaRodjenja(); 
    	Assert.assertEquals("Bihac", opcinaRod1);
    }
    
    
    @Test 
    public void testGetMjestoRodjenja() {
    	String mjesto1; 
    	mjesto1 = s.getMjestoRodjenja(); 
    	Assert.assertEquals("Bihac", mjesto1); 
    }
	
    @Test 
    public void testGetDrzavaRodjenja(){
    	 String drzava1; 
    	 drzava1 = s.getDrzavaRodjenja();
    	 Assert.assertEquals("BiH", drzava1);
    }
    
    @Test
    public void testGetIndeks(){
    	int indeks1; 
    	indeks1 = s.getIndeks(); 
    	Assert.assertEquals(16049, indeks1);
    }
    
    @Test
    public void testGetGodinaStudija()
    {
    	int god1; 
    	god1 = s.getGodinaStudija(); 
    	Assert.assertEquals(3, god1);
    }
    
    @Test 
    public void testGetMail(){
    	String mail1; 
    	mail1 = s.getMail(); 
    	Assert.assertEquals("sgrosic1@etf.unsa.ba", mail1);
    }
    
    @Test
    public void testGetTelefon(){
    	String tel1; 
    	tel1 = s.getTelefon(); 
    	Assert.assertEquals("061/970-280", tel1);
    }
    
    @Test
    public void testGetImeRoditelja(){
    	String imeRod1; 
    	imeRod1 = s.getImeRoditelja(); 
    	Assert.assertEquals("Cazim", imeRod1);
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
