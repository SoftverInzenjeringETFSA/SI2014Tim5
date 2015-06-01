package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class Student implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4465230503418429870L;

	long id;

	private String ime;
	private String prezime;
	private String jmbg;
	private String mail;
	private String adresa;
	private String opcina;
	private String telefon;
	private int indeks;
	private double troskoviSkolarine;
	private double troskoviLiterature;
	private String imeRoditelja;
	private String mjestoRodjenja;
	private String opcinaRodjenja;
	private String drzavaRodjenja;
	private double popust;
	private GodinaStudija godinaStudija;



	public Student(long id, String ime, String prezime, String jmbg,
			String mail, String adresa, String opcina, String telefon,
			int indeks, double troskoviSkolarine, String imeRoditelja,
			String mjestoRodjenja, String opcinaRodjenja,
			String drzavaRodjenja, double popust, GodinaStudija godinaStudija) {
		super();
		this.setId(id);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setJmbg(jmbg);
		this.setMail(mail);
		this.setAdresa(adresa);
		this.setOpcina(opcina);
		this.setTelefon(telefon);
		this.setIndeks(indeks);
		this.setTroskoviSkolarine(troskoviSkolarine);
		this.setImeRoditelja(imeRoditelja);
		this.setMjestoRodjenja(mjestoRodjenja);
		this.setOpcinaRodjenja(opcinaRodjenja);
		this.setDrzavaRodjenja(drzavaRodjenja);
		this.setPopust(popust);
		this.setGodinaStudija(godinaStudija);	
	}

	public Student() {

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
		if(!Validacija.getInstance().validirajIme(ime))throw new IllegalArgumentException("Neispravan format unesenog imena!");
		else {
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
		if(!Validacija.getInstance().validirajIme(prezime))throw new IllegalArgumentException("Neispravan format unesenog prezimena!");
		else {
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
		
		if(!Validacija.getInstance().validirajJmbg(jmbg))
		{
			 throw new IllegalArgumentException("Format JMBG-a nije validan!");
		}
		
		else {
			this.jmbg = jmbg;
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

	public String getOpcina() {
		return opcina;
	}

	public void setOpcina(String opcina) {	
		if(opcina.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli općinu prebivališta!");
		}
		if (!Validacija.getInstance().validirajTekst(opcina))
        {
            throw new IllegalArgumentException("Neispravno unesena općina prebivališta!");
        }
        else
        {
        	this.opcina = opcina;
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

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		if(indeks < 0) throw new IllegalArgumentException("Indeks mora biti pozitivan broj!");
		this.indeks = indeks;
	}

	public double getTroskoviSkolarine() {
		return troskoviSkolarine;
	}

	public void setTroskoviSkolarine(double troskoviSkolarine) {
		if(troskoviSkolarine < 0) throw new IllegalArgumentException("Troskovi skolarine moraju biti pozitivan broj!");
		this.troskoviSkolarine = troskoviSkolarine;
	}

	public double getTroskoviLiterature() {
		return troskoviLiterature;
	}

	public void setTroskoviLiterature(double troskoviLiterature) {
		this.troskoviLiterature = troskoviLiterature;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		if(imeRoditelja.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli ime roditelja!");
		}
		if (!Validacija.getInstance().validirajIme(imeRoditelja))
        {
            throw new IllegalArgumentException("Neispravno uneseno ime roditelja!");
        }
        else
        {
        	this.imeRoditelja = imeRoditelja;
        }
	}

	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}

	public void setMjestoRodjenja(String mjestoRodjenja) {
		if(mjestoRodjenja.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli mjesto rodjenja!");
		}
        else
        {
        	this.mjestoRodjenja = mjestoRodjenja;
        }
	}

	public String getOpcinaRodjenja() {
		return opcinaRodjenja;
	}

	public void setOpcinaRodjenja(String opcinaRodjenja) {
		if(opcinaRodjenja.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli općinu rođenja!");
		}
		if (!Validacija.getInstance().validirajTekst(opcinaRodjenja))
        {
            throw new IllegalArgumentException("Neispravno unesena općina rođenja!");
        }
        else
        {
        	this.opcinaRodjenja = opcinaRodjenja;
        }
        	
	}

	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public void setDrzavaRodjenja(String drzavaRodjenja) {
		if(drzavaRodjenja.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli državu rođenja!");
		}
		if (!Validacija.getInstance().validirajTekst(drzavaRodjenja))
        {
            throw new IllegalArgumentException("Neispravno unesena država rođenja!");
        }
        else
        {
        	this.drzavaRodjenja = drzavaRodjenja;
        }
        	
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}
	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public GodinaStudija getGodinaStudija() {
		return this.godinaStudija;
	}
	
	public double dajUkupniDug() {
		return dajDugZaSkolarinu() + troskoviLiterature;

	}

	public double dajUkupanDug(Session session)
	{
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where studentId = "+this.id+" and jeliizmiren = 0;").addEntity(Dug.class).list();
		t.commit();
		double suma = 0;
		for (int i =0;i<l.size();i++)
			suma+=l.get(i).getVrijednost();
		return suma;
		
	}
	
	public double dajDugZaSkolarinu() {
		return troskoviSkolarine - troskoviSkolarine * popust / 100;
	}
	
	public ArrayList<Dug> dajSveDugove(Session session) {
		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where studentId = "+this.id+";").addEntity(Dug.class).list();
		t.commit();
		return l;
	}

	public long dodajStudenta(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);		
		t.commit();
		return id;
	}

	public void obrisiStudenta(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.delete(this);
		t.commit();		
	}

	public void urediStudenta(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(this);
		t.commit();		
	}
	
	public ArrayList<Rata> dajSveRateZaGodinu(String studijskaGodina) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Rata> rate = new ArrayList<Rata>();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where akademskagodina='"+studijskaGodina+"' and studentid="+ this.id).addEntity(Dug.class).list();		
		t.commit();	
		for(int i=0; i<l.size(); i++) {
			ArrayList<Rata> temp = l.get(i).dajSveRate(session);
			for(int j = 0; j<temp.size(); j++) rate.add(temp.get(i));
		}
		session.close();
		return rate;
	}
	
	public double dajNeisplaceneDugoveLiteratura() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where tipDuga = 'dugZaLiteraturu' and jeLiIzmiren = 0 and studentId = " + this.id).addEntity(Dug.class).list();		
		t.commit();	
		session.close();
		double dug = 0;
		for(int i = 0; i<l.size(); i++) dug += l.get(i).dajVrijednostDuga();
		
		return dug;
	}
	
	public double dajNeisplaceneDugoveSkolarina() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where tipDuga = 'dugZaSkolarinu' and jeLiIzmiren = 0 and studentId = " + this.id).addEntity(Dug.class).list();		
		t.commit();	
		session.close();
		double dug = 0;
		for(int i = 0; i<l.size(); i++) dug += l.get(i).dajVrijednostDuga();
		
		return dug;
	}

}