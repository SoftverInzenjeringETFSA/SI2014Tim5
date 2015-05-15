package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.Date;

import org.hibernate.Session;


public class Rata implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8856035642412109805L;
	private long id;
	private double vrijednost;
	private boolean jeLiUplacena;
	private Date datumZaduzenja;
	private Date datumRazduzenja;
	private Date rokUplate;	
	private long dugId;
	
	public Rata() {}
	public Rata(long id, double vrijednost, boolean jeLiUplacena, Date datumZaduzenja,
			Date datumRazduzenja, Date rokUplate, long dugId) {
		super();
		this.id = id;
		this.vrijednost = vrijednost;
		this.jeLiUplacena = jeLiUplacena;
		this.datumZaduzenja = datumZaduzenja;
		this.datumRazduzenja = datumRazduzenja;
		this.rokUplate = rokUplate;
		this.dugId = dugId;
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
	public double getVrijednost() {
		return vrijednost;
	}
	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}
	public boolean isJeLiUplacena() {
		return jeLiUplacena;
	}
	public void setJeLiUplacena(boolean jeLiUplacena) {
		this.jeLiUplacena = jeLiUplacena;
	}
	public Date getDatumZaduzenja() {
		return datumZaduzenja;
	}
	public void setDatumZaduzenja(Date datumZaduzenja) {
		this.datumZaduzenja = datumZaduzenja;
	}
	public Date getDatumRazduzenja() {
		return datumRazduzenja;
	}
	public void setDatumRazduzenja(Date datumRazduzenja) {
		this.datumRazduzenja = datumRazduzenja;
	}
	public Date getRokUplate() {
		return rokUplate;
	}
	public void setRokUplate(Date rokUplate) {
		this.rokUplate = rokUplate;
	}
	
	public void dodajRatu(Session session) {
		
	}
	public void urediRatu(Session session) {
		
	}
}
