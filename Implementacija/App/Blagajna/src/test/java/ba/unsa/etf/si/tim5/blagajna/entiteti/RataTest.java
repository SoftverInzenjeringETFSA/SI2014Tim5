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

	Date d1 = new Date();
	Date d2 = new Date();
	Date d3 = new Date();
	
	Rata rata = new Rata(15, 250, true, d1, d2, d3, 6);

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
		Assert.assertEquals(6, rata.getDugId());
	}

	@Test
	public void testSetDugId() {
		rata.setDugId(5);
		Assert.assertNotEquals(6, rata.getDugId());
	}

	@Test
	public void testGetId() {
		Assert.assertNotEquals(15, rata.getDugId());
	
	}

	@Test
	public void testSetId() { // TODO
		rata.setId(12);
		Assert.assertNotEquals(15, rata.getDugId());

}

	@Test
	public void testGetVrijednost() {
		Assert.assertNotEquals(201, rata.getVrijednost());
	}

	@Test
	public void testSetVrijednost() {
		rata.setVrijednost(1500);
		Assert.assertNotEquals(200, rata.getVrijednost());
	}


	@Test
	public void testGetDatumZaduzenja() {
		Date d = rata.getDatumZaduzenja();
		Assert.assertEquals(d, rata.getDatumZaduzenja());
	}

	@Test
	public void testSetDatumZaduzenja() {
		Date d = rata.getDatumZaduzenja();
		rata.setDatumZaduzenja(new Date());
		Assert.assertNotEquals(d, rata.getDatumZaduzenja());
	}

	@Test
	public void testGetDatumRazduzenja() {
		Date d = rata.getDatumRazduzenja();
		Assert.assertEquals(d, rata.getDatumRazduzenja());
	}

	@Test
	public void testSetDatumRazduzenja() {
		Date d = rata.getDatumRazduzenja();
		rata.setDatumRazduzenja(new Date());
		Assert.assertNotEquals(d, rata.getDatumRazduzenja());
}

	@Test
	public void testGetRokUplate() {
		Date d = rata.getRokUplate();
		Assert.assertEquals(d, rata.getRokUplate());
		}

	@Test
	public void testSetRokUplate() {
		Date d = rata.getRokUplate();
		rata.setRokUplate(new Date());
		Assert.assertNotEquals(d, rata.getRokUplate());
	}

	@Test
	public void testDodajRatu() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUrediRatu() {
		fail("Not yet implemented"); // TODO
	}


}
