package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class UpozorenjeZaDug {
	
	private ArrayList<Dug> dugovi;
	private ArrayList<String> mailoviStudenata;
	private ArrayList<String> poruke;
	
	public UpozorenjeZaDug() {
		mailoviStudenata = new ArrayList<String>();
		poruke = new ArrayList<String>();
	}
	
	 
	public int dajRazlikuDatuma(Date date1, Date date2) {
		final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		return (int) ((date1.getTime() - date2.getTime())/ DAY_IN_MILLIS );
	}
	
	public void provjeriDugove() {
		dugovi = Dao.getInstance().dajSveDugove("SELECT * FROM DUG WHERE JELIIZMIREN = 0;");
		Session session = HibernateUtil.getSessionFactory().openSession();
		for(int i=0; i<dugovi.size(); i++) {
			ArrayList<Rata> rate = dugovi.get(i).dajSveRate(session);			
			
			for(int j = 0; j < rate.size(); j++) {
				if(Math.abs(dajRazlikuDatuma(rate.get(j).getRokUplate(), new Date())) < 30) {
					mailoviStudenata.add(dugovi.get(i).dajStudenta().getMail());
					if(dugovi.get(i).getTipDuga() == TipDuga.dugZaLiteraturu) 
						poruke.add("Niste izmirili svoje obaveze prema fakultetu. Imate neisplaćene dugove za literaturu !");
					else poruke.add("Niste izmirili svoje obaveze prema fakultetu. Imate neisplaćene dugove za školarinu !");
					break;
				}
			}				
		}
		session.close();
	}
	

	
	
	public void posaljiMail() {
		
	}
}
