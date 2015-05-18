package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

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
	private int godinaStudija;
	private long dugId;

	public Student(long id, String ime, String prezime, String jmbg,
			String mail, String adresa, String opcina, String telefon,
			int indeks, double troskoviSkolarine, String imeRoditelja,
			String mjestoRodjenja, String opcinaRodjenja,
			String drzavaRodjenja, double popust, int godinaStudija) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.mail = mail;
		this.adresa = adresa;
		this.opcina = opcina;
		this.telefon = telefon;
		this.indeks = indeks;
		this.troskoviSkolarine = troskoviSkolarine;
		this.imeRoditelja = imeRoditelja;
		this.mjestoRodjenja = mjestoRodjenja;
		this.opcinaRodjenja = opcinaRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
		this.popust = popust;
		this.godinaStudija = godinaStudija;		
	}

	public Student() {

	}

	public long getDugId() {
		return dugId;
	}

	public void setDugId(long dugId) {
		this.dugId = dugId;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOpcina() {
		return opcina;
	}

	public void setOpcina(String opcina) {
		this.opcina = opcina;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}

	public double getTroskoviSkolarine() {
		return troskoviSkolarine;
	}

	public void setTroskoviSkolarine(double troskoviSkolarine) {
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
		this.imeRoditelja = imeRoditelja;
	}

	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}

	public void setMjestoRodjenja(String mjestoRodjenja) {
		this.mjestoRodjenja = mjestoRodjenja;
	}

	public String getOpcinaRodjenja() {
		return opcinaRodjenja;
	}

	public void setOpcinaRodjenja(String opcinaRodjenja) {
		this.opcinaRodjenja = opcinaRodjenja;
	}

	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public void setDrzavaRodjenja(String drzavaRodjenja) {
		this.drzavaRodjenja = drzavaRodjenja;
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public double dajUkupniDug() {
		return dajDugZaSkolarinu() + troskoviLiterature;
	}
	
	public double dajDugZaSkolarinu() {
		return troskoviSkolarine - troskoviSkolarine * popust / 100;
	}
	
	public ArrayList<Dug> dajSveDugove(Session session) {
		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM dug where korisnikId = "+this.id+";").addEntity(Dug.class).list();
		t.commit();
		return l;
	}

	public void izvrsiUplatu(Rata rata) {

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

}
