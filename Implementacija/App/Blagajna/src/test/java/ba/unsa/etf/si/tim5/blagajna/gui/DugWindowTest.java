package ba.unsa.etf.si.tim5.blagajna.gui;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

public class DugWindowTest extends DugWindow {
	@Test
	public void testDajDatum()
	{
		Date d = new Date();
		d.setDate(12);
		d.setMonth(4);
		d.setYear(2014);
		String s = dajDatum(d);
		Assert.assertEquals("12.04.2014", s);	
	}

	
	
}
