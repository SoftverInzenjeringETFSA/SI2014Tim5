package ba.unsa.etf.si.tim5.blagajna.entiteti;
import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
//		//Literatura l = new Literatura(8, "xxx", "asd", "asd", 1, 42.3);
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		Korisnik k = new Korisnik(1,"admin","admin","2311991170041","aef","062/772-669","aef",TipKorisnika.Administrator,"admin", "admin");
//		
//		k.dodajKorisnika(session);
//
//		session.close();
//		
		String[] m = {"faris.dzafic@outlook.com"};
		SlanjeMaila.getInstance().sendFromGMail(m, "Test", "Test");	
		System.out.println("izmjenjeno");
	}
}
