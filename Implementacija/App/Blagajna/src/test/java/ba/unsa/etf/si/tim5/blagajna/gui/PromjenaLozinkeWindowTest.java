package ba.unsa.etf.si.tim5.blagajna.gui;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;

public class PromjenaLozinkeWindowTest extends TestCase {

	@Test
	public void testPassTrue() {
		String pass = "!aaA123gf44";
		Assert.assertEquals(true, Validacija.getInstance().passwordValidation(pass));
	
	}
	public void testPassFalse() {
		String pass = "!aaaaaaaa1";
		Assert.assertEquals(false, Validacija.getInstance().passwordValidation(pass));
	
	}

}
