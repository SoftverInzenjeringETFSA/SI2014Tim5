package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import ba.unsa.etf.si.tim5.blagajna.dodaci.PorukaMail;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class UpozorenjeZaDug {	
	
	private ArrayList<Dug> dugovi;
	private ArrayList<PorukaMail> poruke;
	
	public UpozorenjeZaDug() {
		
	}
	
	 
	public int dajRazlikuDatuma(Date date1, Date date2) {
		final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		return (int) ((date1.getTime() - date2.getTime())/ DAY_IN_MILLIS );
	}
	
	public void provjeriDugove() {
		poruke = new ArrayList<PorukaMail>();
		dugovi = Dao.getInstance().dajSveDugove("SELECT * FROM DUG WHERE JELIIZMIREN = 0;");
		Session session = HibernateUtil.getSessionFactory().openSession();
		for(int i=0; i<dugovi.size(); i++) {
			ArrayList<Rata> rate = dugovi.get(i).dajSveRate(session);			
			
			for(int j = 0; j < rate.size(); j++) {
				if(Math.abs(dajRazlikuDatuma(rate.get(j).getRokUplate(), new Date())) < 30) {					
					PorukaMail pm = new PorukaMail();
					
					if(dugovi.get(i).getTipDuga() == TipDuga.dugZaLiteraturu) 
						pm.postaviDugZaLiteraturu(dugovi.get(i).dajStudenta().getMail(), rate.get(i).getRokUplate().toString());
					else pm.postaviDugZaSkolarinu(dugovi.get(i).dajStudenta().getMail(), rate.get(i).getRokUplate().toString());
					
					poruke.add(pm);
					break;
				}
			}				
		}
		session.close();
	}
	

	
	
	public void posaljiMail() {
		if(poruke == null) provjeriDugove();
		if(poruke.size() == 0) return;
	
		for(int i = 0; i<poruke.size(); i++) {
			String[] mail = {poruke.get(i).getMail()};
			SlanjeMaila.getInstance().sendFromGMail(mail, poruke.get(i).getNaslov(), poruke.get(i).getPoruka());
			
		}
		
	}
}
