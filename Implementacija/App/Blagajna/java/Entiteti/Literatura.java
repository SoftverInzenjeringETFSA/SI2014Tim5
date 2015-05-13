package Entiteti;

import org.hibernate.Session;


public class Literatura implements java.io.Serializable {
	/**
	 * 
	 */
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
		this.naziv = naziv;
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
		this.isbn = isbn;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
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

	public void dodajLiteraturu(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
	}
	
	public void obrisiLiteraturu(Session session) {
		
	}
	
}
