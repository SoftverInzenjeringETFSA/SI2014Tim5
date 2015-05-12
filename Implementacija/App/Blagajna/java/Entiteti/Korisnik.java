package Entiteti;

import Dodaci.TipKorisnika;

import java.util.*;

import org.hibernate.Session;

public class Korisnik implements java.io.Serializable{
	private long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;	
	private String telefon;
	private String mail;
	private TipKorisnika tipKorisnika;
	private ArrayList<Izvjestaj> izvjestaji;
	
	
	public Korisnik() {
		izvjestaji = new ArrayList<Izvjestaj>();
	}
	
	public Korisnik(long id, String ime, String prezime, String jmbg, String adresa,
			String telefon, String mail, TipKorisnika tipKorisnika,
			ArrayList<Izvjestaj> izvjestaji) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.telefon = telefon;
		this.mail = mail;
		this.tipKorisnika = tipKorisnika;
		this.izvjestaji = izvjestaji;
	}
	public long getId() {
		return id;
	}
	public void setId() {
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
	public ArrayList<Izvjestaj> getIzvjestaji() {
		return izvjestaji;
	}
	public void setIzvjestaji(ArrayList<Izvjestaj> izvjestaji) {
		this.izvjestaji = izvjestaji;
	}
	
	public void registrujIzvjestaj(Izvjestaj izvjestaj) {
		
	}
	
	public void dodajKorisnika(Session session) {
		
	}
	public void obrisiKorisnika(Session session) {
		
	}
	
	public void urediKorisnika(Session session) {
		
	}
}
