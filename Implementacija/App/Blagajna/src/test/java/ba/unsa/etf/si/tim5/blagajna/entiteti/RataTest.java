package ba.unsa.etf.si.tim5.blagajna.entiteti;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class RataTest extends TestCase {

	Date d1 = New Date();
	
	Rata rata = new Rata(15, 250, true, "31-10-2014"., "25-11-2014", "01-12-2014", 6);
	

	
	@Test
	public void testRata() {
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			String d1 = "31-10-2014";
			Date datum1 = sdf.parse(d1);
			String d2 = "31-11-2014";
			Date datum2 = sdf.parse(d2);
			String d3 = "10-12-2014";
			Date datum3 = sdf.parse(d3);			
			Rata rata = new Rata(20, 200, true, datum1, datum2, datum3, 5);
		}
		catch(Exception e)
		{
			Assert.fail("Test fail - init rata");	
		}

	}

	@Test
	public void testGetDugId() {
		Assert.assertEquals(5, rata.getDugId());
	}

	@Test
	public void testSetDugId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetId() {
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetVrijednost() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetVrijednost() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIsJeLiUplacena() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetJeLiUplacena() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDatumZaduzenja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDatumZaduzenja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDatumRazduzenja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDatumRazduzenja() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRokUplate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRokUplate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDodajRatu() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUrediRatu() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

}
