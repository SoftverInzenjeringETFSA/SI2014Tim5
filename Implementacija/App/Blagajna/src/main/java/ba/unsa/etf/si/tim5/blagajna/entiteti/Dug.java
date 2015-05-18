package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;

public class Dug implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6950513813519064755L;
	private long id;		
	private boolean jeLiIzmiren;
	private String akademskaGodina;
	double vrijednost;
	private long korisnikId;
	TipDuga tipDuga;
	
	public Dug() {
	}
			
	
	

	
	
	public Dug(long id, boolean jeLiIzmiren, String akademskaGodina,
			double vrijednost, long korisnikId, TipDuga tipDuga) {
		super();
		this.id = id;
		this.jeLiIzmiren = jeLiIzmiren;
		this.akademskaGodina = akademskaGodina;
		this.vrijednost = vrijednost;
		this.korisnikId = korisnikId;
		this.tipDuga = tipDuga;
	}






	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public boolean isJeLiIzmiren() {
		return jeLiIzmiren;
	}


	public void setJeLiIzmiren(boolean jeLiIzmiren) {
		this.jeLiIzmiren = jeLiIzmiren;
	}


	public String getAkademskaGodina() {
		return akademskaGodina;
	}


	public void setAkademskaGodina(String akademskaGodina) {
		this.akademskaGodina = akademskaGodina;
	}


	public double getVrijednost() {
		return vrijednost;
	}


	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}


	public long getKorisnikId() {
		return korisnikId;
	}


	public void setKorisnikId(long korisnikId) {
		this.korisnikId = korisnikId;
	}


	public TipDuga getTipDuga() {
		return tipDuga;
	}


	public void setTipDuga(TipDuga tipDuga) {
		this.tipDuga = tipDuga;
	}


	public ArrayList<Rata> dajSveRate(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Rata> l = (ArrayList<Rata>)session.createSQLQuery("SELECT * FROM rata where dugId = "+this.id+";").addEntity(Rata.class).list();
		t.commit();
		return l;
		
	}
	
	public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
	public long dodajDug(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long)session.save(this);
		t.commit();
		Rata r1 = new Rata(1, this.vrijednost/4, false, new Date(),
				null, addDays(new Date(), 90), this.id);
		Rata r2 = new Rata(1, this.vrijednost/4, false, new Date(),
				null, addDays(new Date(), 90), this.id);
		Rata r3 = new Rata(1, this.vrijednost/4, false, new Date(),
				null, addDays(new Date(), 90), this.id);
		Rata r4 = new Rata(1, this.vrijednost/4, false, new Date(),
				null, addDays(new Date(), 90), this.id);
		r1.dodajRatu(session);
		r2.dodajRatu(session);
		r3.dodajRatu(session);
		r4.dodajRatu(session);				
		return id;
	}	
	
	public void urediDug(Session session) { // kad se izmiri dug potrebno je urediti to u bazi
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(this);
		t.commit();		
	}
	
	
}
