package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		this.setId(id);
		this.setIme(ime); 
		this.setPrezime(prezime);
		this.setJmbg(jmbg);
		this.setAdresa(adresa);
		this.setMail(mail);
		this.setTelefon(telefon);
		this.setTipKorisnika(tipKorisnika);		
		this.setKorisnickoIme(korisnickoIme);
		this.setLozinka(lozinka); 
	}
	
	
	public String getKorisnickoIme() {
		
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		if(korisnickoIme.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli korisnicko ime!");
		}
		if(!Validacija.getInstance().validirajUsername(korisnickoIme))throw new IllegalArgumentException("Korisnicko ime mora biti duze od 3 i manje od 36 znakova!");
		else {
			this.korisnickoIme = korisnickoIme;
			}
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
		if(ime.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli ime!");
		}
		if (!Validacija.getInstance().validirajIme(ime))
        {
            throw new IllegalArgumentException("Neispravno uneseno ime!");
        }
        else
        {
        	this.ime = ime;
        }
		
	}
	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if(prezime.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli prezime!");
		}
		if (!Validacija.getInstance().validirajIme(prezime))
        {
            throw new IllegalArgumentException("Neispravno uneseno prezime!");
        }
        else
        {
        	this.prezime = prezime;
        }
		
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		
		if(jmbg.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli JMBG!");
		}
		
		if(jmbg.length()!=13)
		{
			 throw new IllegalArgumentException("Format JMBG-a nije validan!");
		}
		/*if (!Validacija.getInstance().jmbgValidation(jmbg))
        {
            throw new IllegalArgumentException("Neispravno unesen JMBG!");
        }*/
		else {
			this.jmbg = jmbg;
		}
       // }
		
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		if(adresa.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli adresu!");
		}
		if (!Validacija.getInstance().validirajAdresu(adresa))
        {
            throw new IllegalArgumentException("Neispravno unesena adresa!");
        }
        else
        {
        	this.adresa = adresa;
        }
		
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		if(telefon.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli telefon!");
		}
		if (!Validacija.getInstance().validirajTelefon(telefon))
        {
            throw new IllegalArgumentException("Neispravno unesen telefon! Podrzani format je XXX/XXX-XXX.");
        }
        else
        {
        	this.telefon = telefon;
        }
		
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		
		if(mail.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli mail!");
		}
		if (!Validacija.getInstance().validirajMail(mail))
        {
            throw new IllegalArgumentException("Neispravno unesen mail! Primjer je: mail1@example.com");
        }
        else
        {
        	this.mail = mail;
        }
		
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
