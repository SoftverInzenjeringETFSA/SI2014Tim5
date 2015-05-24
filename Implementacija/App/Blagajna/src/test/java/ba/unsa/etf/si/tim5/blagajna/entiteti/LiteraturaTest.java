package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LiteraturaTest extends Literatura {
	
	long id = 1;
	String isbn = "ISBN 978-0-300-14424-6";
	String naziv = "Prokleta avlija";
	String autor = "Ivo Andric";
	int kolicina = 2;
	double cijena = 100;
	
	Literatura l = new Literatura(id, isbn, naziv, autor, kolicina, cijena); 
	
	/*@Test
	public void testGetId() {
		long id1;
		id1=l.getId(); 
		Assert.assertEquals(1, id1);
	}
	
	@Test
	public void testGetIsbn(){
		String isbn1; 
		isbn1 = l.getIsbn(); 
		Assert.assertEquals("ISBN 978-0-300-14424-6", isbn1);
	}
	
	@Test 
	public void testGetNaziv(){
		String naziv1; 
		naziv1 = l.getNaziv(); 
		Assert.assertEquals("Prokleta avlija", naziv1);
	}
	
	@Test 
	public void testGetAutor(){
		String autor1; 
		autor1 = l.getAutor(); 
		Assert.assertEquals("Ivo Andric", autor1);
	}
	
	@Test
	public void testGetKolicina(){
		int kolicina1; 
		kolicina1 = l.getKolicina(); 
		Assert.assertEquals(2, kolicina1);
	}
	
	

    @Test
   	public void testSetIsbn() {
   		try {
   			
   			l.setIsbn("ISBN 978-0-300-14424-6");
   			
   			Assert.assertEquals("ISBN 978-0-300-14424-6" , l.getIsbn());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getIsbn");
   		}
   	}
	
    @Test
   	public void testSetNaziv() {
   		try {
   			
   			l.setNaziv("Prokleta avlija"); 
   			
   			Assert.assertEquals("Prokleta avlija" , l.getNaziv());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getNaziv");
   		}
   	}
    
    @Test 
    public void testSetAutor(){
    	
    	try {
   			
   			l.setAutor("Ivo Andric");
   			
   			Assert.assertEquals("Ivo Andric" , l.getAutor());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getAutor");
   		}
    	
    }
    
    @Test 
    public void testSetKolicina(){
    	
    	try {
   			
   			l.setKolicina(2);
   			
   			Assert.assertEquals(2 , l.getKolicina());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getKolicina");
   		}
    }
    
    
    @Test 
    public void testSetId(){
    	
    	try {
   			
   			l.setId(1); 
   			
   			Assert.assertEquals(1 , l.getId());
   		} 
   		
   		catch (Exception e) {
   			
   			Assert.fail("Test failed - getId");
   		}
    }
    
    */
}
