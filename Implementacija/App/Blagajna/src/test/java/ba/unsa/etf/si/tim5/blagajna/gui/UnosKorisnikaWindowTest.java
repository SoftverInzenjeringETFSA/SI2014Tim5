package ba.unsa.etf.si.tim5.blagajna.gui;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;

public class UnosKorisnikaWindowTest extends UnosKorisnikaWindow{

	@Test
	public void testPopuniPolja() {
	
		Korisnik k=new Korisnik(1,"Def","Aef","2311991170041","Eaef","033/666-555","aef@aef.vv",TipKorisnika.values()[0],"dino1","admin");
		UnosKorisnikaWindow.popuniPolja(k);
		
	}

}
