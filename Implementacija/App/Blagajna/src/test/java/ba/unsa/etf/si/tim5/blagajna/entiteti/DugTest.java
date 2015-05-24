package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;

public class DugTest extends Dug {
	
	 long id = 1;
	 boolean jeLiIzmiren = true;
	 String akademskaGodina = "2014/2015";
	 double vrijednost = 100;
	 long studentId = 1;
	 TipDuga tipDuga = TipDuga.dugZaSkolarinu;
	 long literaturaId = 1;
	 
	 Dug d = new Dug(id, jeLiIzmiren,akademskaGodina,
			vrijednost,  studentId,  tipDuga); 
	 
	 @Test
		public void testGetId() {
			long id1;
			id1=d.getId();
			Assert.assertEquals(1, id1);
		}
	 
	 @Test
		public void testGetAkademskaGodina() {
			String god; 
			god = d.getAkademskaGodina(); 			
			Assert.assertEquals("2014/2015", god);
		}
	 
	 @Test 
	 	public void testGetVrijednost(){
		 double vr1; 
		 vr1 = d.getVrijednost(); 
		 Assert.assertEquals(100, vr1, 0);
	 }
	 
	 
	 @Test 
	 public void testGetTipDuga(){
		 TipDuga a; 
		 a = d.getTipDuga(); 
		 Assert.assertEquals(TipDuga.dugZaSkolarinu, a);
		 
	 }
	 
	 @Test 
	 public void testGetStudentId(){
		 long sid; 
		 sid = d.getStudentId(); 
		 Assert.assertEquals(1, sid);
	 }
	 
	 @Test 
	    public void testSetVrijednost(){
	    	try{
	    	
	    		d.setVrijednost(100); 
	    		Assert.assertEquals(100, d.getVrijednost(), 0);
	    	}
	    	catch(Exception e){
	    		
	    		Assert.fail("Test failed - getVrijednost");
	    	}
	    }
	 
	 @Test 
	    public void testSetTipDuga(){
	    	try{
	    	
	    		d.setTipDuga(TipDuga.dugZaSkolarinu);
	    		Assert.assertEquals(TipDuga.dugZaSkolarinu, d.getTipDuga());
	    	}
	    	catch(Exception e){
	    		
	    		Assert.fail("Test failed - getTipDuga");
	    		
	    	}
	    }
	 
	 @Test 
	 public void testSetAkademskaGodina(){
		 try{
		    	
	    		d.setAkademskaGodina("2014/2015");
	    		Assert.assertEquals("2014/2015", d.getAkademskaGodina());
	    	}
	    	catch(Exception e){
	    		
	    		Assert.fail("Test failed - getAkademskaGodina");
	    		
	    	}
	 }
	 
	 @Test 
	 public void testSetStudentId(){
		 try{
		    	
	    		d.setStudentId(1);
	    		Assert.assertEquals(1, d.getStudentId());
	    	}
	    	catch(Exception e){
	    		
	    		Assert.fail("Test failed - getStudentId");
	    		
	    	}
	 }
	 
	 

}
