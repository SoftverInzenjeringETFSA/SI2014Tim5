package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;

import org.hibernate.Session;

public class Korisnik implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 791360639196831629L;
	private long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;	
	private String telefon;
	private String mail;
	private TipKorisnika tipKorisnika;	
	private String korisnickoIme;
	private String lozinka;
	
	public Korisnik() {		
	}
	
	public Korisnik(long id, String ime, String prezime, String jmbg, String adresa,
			String telefon, String mail, TipKorisnika tipKorisnika, String korisnickoIme, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.telefon = telefon;
		this.mail = mail;
		this.tipKorisnika = tipKorisnika;		
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}
	
	
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}
	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
	public TipKorisnika ToTipKorisnika(String s){
		if(s=="Korisnik") return TipKorisnika.values()[0];
		else return TipKorisnika.values()[1];
	}
	
	public void dodajKorisnika(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long)session.save(this);
		t.commit();
	}
	
	public void obrisiKorisnika(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.delete(this);
		t.commit();	
	}
	
	public void urediKorisnika(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(this);
		t.commit();		
	}	
}
