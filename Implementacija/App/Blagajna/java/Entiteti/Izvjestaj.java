package Entiteti;

import java.util.*;

import org.hibernate.Session;

public class Izvjestaj implements java.io.Serializable{
	private Date datum;
	private String sadrzaj;
	private Korisnik kreator;
	
	public Izvjestaj() {}
	
	public Izvjestaj(Date datum, String sadrzaj, Korisnik kreator) {
		super();
		this.datum = datum;
		this.sadrzaj = sadrzaj;
		this.kreator = kreator;
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
	public Korisnik getKreator() {
		return kreator;
	}
	public void setKreator(Korisnik kreator) {
		this.kreator = kreator;
	}
	
	public void dodajIzvjestaj(Session session) {
		
	}
} 
