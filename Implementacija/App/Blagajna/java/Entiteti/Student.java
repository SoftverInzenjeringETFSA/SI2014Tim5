package Entiteti;

import java.util.ArrayList;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

public class Student implements java.io.Serializable {	
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
	private ArrayList<Dug> dugovi;

	public Student(long id, String ime, String prezime, String jmbg,
			String mail, String adresa, String opcina, String telefon,
			int indeks, double troskoviSkolarine, double troskoviLiterature,
			String imeRoditelja, String mjestoRodjenja, String opcinaRodjenja,
			String drzavaRodjenja, double popust, int godinaStudija, ArrayList<Dug> dugovi) {
		super();
		this.dugovi = dugovi;
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
		this.troskoviLiterature = troskoviLiterature;
		this.imeRoditelja = imeRoditelja;
		this.mjestoRodjenja = mjestoRodjenja;
		this.opcinaRodjenja = opcinaRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
		this.popust = popust;
		this.godinaStudija = godinaStudija;
	}
	
	public Student() {
		dugovi = new ArrayList<Dug>();
	}
	
	public ArrayList<Dug> getDugovi() {
		return dugovi;
	}
	
	public void setDugovi(ArrayList<Dug> dugovi) {
		this.dugovi = dugovi;
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
		return 0;
	}
	
	public void izvrsiUplatu(Rata rata) {
		
	}
	

	public void dodajStudenta(Session session) throws SecurityException,
			RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		try {
			Transaction t = (Transaction) session.beginTransaction();			
			session.save(this);
			System.out.println("Dodan student sa IDom " + this.id);
			t.commit();
		} catch (Exception ex) {
			System.out.println("Izuzetak " + ex.getMessage());
		}
	}
	
	public void obrisiStudenta(Session session) {
	}
	public void urediStudenta(Session session) {
		
	}	

}
