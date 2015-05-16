package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.*;

import org.hibernate.Session;

public class Izvjestaj implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 17517537130146810L;
	private long id;
	private Date datum;
	private String sadrzaj;
	private long korisnikId;
	
	public Izvjestaj() {}
	
	public Izvjestaj(long id, Date datum, String sadrzaj, long korisnikId) {
		super();
		this.id = id;
		this.datum = datum;
		this.sadrzaj = sadrzaj;
		this.korisnikId = korisnikId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	
	public long getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(long korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	public Korisnik dajKreatora() {
		return null;
	}

	public long dodajIzvjestaj(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long)session.save(this);
		t.commit();
		return id;
	}
} 
