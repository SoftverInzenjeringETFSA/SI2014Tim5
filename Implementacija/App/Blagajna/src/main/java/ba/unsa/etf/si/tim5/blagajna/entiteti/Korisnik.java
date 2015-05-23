package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;

import java.util.ArrayList;

import org.hibernate.Session;

public class Korisnik implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 791360639196831629L;
	private static long id;
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
		if(!validirajIsto(jmbg,telefon,mail,korisnickoIme)) throw new IllegalArgumentException();
		this.setIme(ime); 
		this.setPrezime(prezime);
		this.setJmbg(jmbg);
		this.setAdresa(adresa);
		this.setMail(mail);
		this.setTelefon(telefon);
		this.setTipKorisnika(tipKorisnika);		
		this.korisnickoIme = korisnickoIme;
		this.setLozinka(lozinka);
		
	}
	
	
	public String getKorisnickoIme() {
		
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		if(ime.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli korisnicko ime!");
		}
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
		else if (!validirajIme(ime))
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
		if (!validirajIme(prezime))
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
		
		/*if (!Validacija.jmbgValidation(jmbg))
        {
            throw new IllegalArgumentException("Neispravno unesen JMBG!");
        }
        else
        
        {*/
		if(jmbg.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli JMBG!");
		}
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
		if (!validirajAdresu(adresa))
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
		else if (!validirajTelefon(telefon))
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
		else if (!Validacija.emailValidation(mail))
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
	
	
	
	

	private static Boolean validirajUsername(String t) {
			if (t.length()<4 ) return false;
			if (t.length() > 35) return false;
			return true;
		}
		
		
		private static Boolean validirajTelefon(String t)
		{
			Pattern pattern = Pattern.compile("\\d{3}/\\d{3}-\\d{3}");
		    Matcher matcher = pattern.matcher(t);
		    if (matcher.matches()) return true;
		    else return false;
		}
		
		private static Boolean validirajAdresu(String t) {
			if (t.length() > 44) return false;
			if (t.length() < 4 ) return false;
			return true;
		}
		
		protected static Boolean validirajMail(String t)
		{
			if (t.length() > 35) return false;
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(t);
			if (matcher.matches()) return true;
			else return false;
		}
		
		protected static Boolean validirajIme(String ime) {
			if (ime.length() > 30) return false;
			else if(ime.length() <2) return false;
			Pattern pattern = Pattern.compile("^[A-Z|Č|Ć|Ž|Š|Đ]{1}[a-z|č|ć|ž|š|đ]{2,}$");
			Matcher matcher = pattern.matcher(ime);
			if (matcher.matches())	return true;
			else return false;
		}
		
		protected static Boolean validirajIsto(String jmbg,String telefon,String mail,String username) {
			
			ArrayList<Korisnik>korisnici= Dao.getInstance().dajSveKorisnike();
			for(int i=0;i<korisnici.size();i++)
			{
				if(username==korisnici.get(i).getKorisnickoIme()){
					throw new IllegalArgumentException("Korisnicko ime vec postoji!");
				}	
				if(jmbg==korisnici.get(i).getJmbg()){ 
					throw new IllegalArgumentException("JMBG vec postoji!");
				}
				if(telefon==korisnici.get(i).getTelefon()){
					throw new IllegalArgumentException("Telefon vec postoji!");
				}
				if(mail==korisnici.get(i).getMail()){
					throw new IllegalArgumentException("Mail vec postoji!");
				}
			}
			return true;
		}
		
		
}
