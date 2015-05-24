package ba.unsa.etf.si.tim5.blagajna.entiteti;


import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;


public class Literatura implements java.io.Serializable {
	/**
	 * 
	 */
	//final static Logger logger = Logger.getLogger(Literatura.class);
	
	private static final long serialVersionUID = -5006244416455980668L;
	private long id;
	private String isbn;
	private String naziv;
	private String autor;
	private int kolicina;
	private double cijena;
	
	public Literatura() {}
	public Literatura(long id, String isbn, String naziv, String autor, int kolicina,
			double cijena) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.setIsbn(isbn);;
		this.autor = autor;
		this.kolicina = kolicina;
		this.cijena = cijena;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		if(isbn.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli ISBN!");
		}
		
		if(!Validacija.getInstance().isbnValidation(isbn))
		{
			 throw new IllegalArgumentException("Format ISBN-a nije validan!");
		}
		else {
			
			this.isbn = isbn;
		}		
		
	}
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		if(naziv.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli naziv knjige!");
		}
		
		if(!Validacija.getInstance().validirajIme(naziv))
		{
			 throw new IllegalArgumentException("Naziv knjige nije validan!");
		}
		else {
			
			this.naziv = naziv;
		}		
	
		
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		if(autor.equals("")) 
		{
			 throw new IllegalArgumentException("Niste unijeli autora knjige!");
		}
		
		if(!Validacija.getInstance().validirajIme(autor))
		{
			 throw new IllegalArgumentException("Polje autor nije validno!");
		}
		else {
			
			this.autor = autor;
		}		
		
		
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public long dodajLiteraturu(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long)session.save(this);
		t.commit();
		return id;
	}
	
	public void obrisiLiteraturu(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.delete(this);
		t.commit();		
	}
	
	@Override
	public String toString() {
		return this.getNaziv();
	}
	
}
