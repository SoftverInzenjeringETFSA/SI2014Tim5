package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;


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
			
	
	public Dug(long id, long rataId, long literaturaId, boolean jeLiIzmiren,
			String akademskaGodina, double vrijednost, long korisnikId, TipDuga tipDuga) {
		super();
		this.id = id;
		this.korisnikId = korisnikId;		
		this.jeLiIzmiren = jeLiIzmiren;
		this.akademskaGodina = akademskaGodina;
		this.vrijednost = vrijednost;
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
		return null;
		
	}
	
	public long dodajDug(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long)session.save(this);
		t.commit();
		return id;
	}
	
	public void urediDug(Session session) { // kad se izmiri dug potrebno je urediti to u bazi
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(this);
		t.commit();		
	}
	
	
}
