package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;


public class Dug implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6950513813519064755L;
	private long id;
	private ArrayList<Rata> rate; //ako je tip duga dugZaLiteraturu, ovo je null,
	private ArrayList<Literatura> literature; // u suprotnom je ovo null
	private boolean jeLiIzmiren;
	private String akademskaGodina;
	double vrijednost;
	TipDuga tipDuga;
	
	public Dug() {
		rate = new ArrayList<Rata>();
		literature = new ArrayList<Literatura>();
	}
		
	
	public Dug(long id, ArrayList<Rata> rate, ArrayList<Literatura> literature,
			boolean jeLiIzmiren, String akademskaGodina, double vrijednost,
			TipDuga tipDuga) {
		super();
		this.id = id;
		this.rate = rate;
		this.literature = literature;
		this.jeLiIzmiren = jeLiIzmiren;
		this.akademskaGodina = akademskaGodina;
		this.vrijednost = vrijednost;
		this.tipDuga = tipDuga;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ArrayList<Rata> getRate() {
		return rate;
	}
	public void setRate(ArrayList<Rata> rate) {
		this.rate = rate;
	}
	public ArrayList<Literatura> getLiterature() {
		return literature;
	}
	public void setLiterature(ArrayList<Literatura> literature) {
		this.literature = literature;
	}
	public boolean isJeLiIzmiren() {
		return jeLiIzmiren;
	}
	public void setJeLiIzmiren(boolean jeLiIzmiren) {
		this.jeLiIzmiren = jeLiIzmiren;
	}
	public String getAkademskaGodina() {
		return akademskaGodina;
	}
	public void setAkademskaGodina(String akademskaGodina) {
		this.akademskaGodina = akademskaGodina;
	}
	public double getVrijednost() {
		return vrijednost;
	}
	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}
	public TipDuga getTipDuga() {
		return tipDuga;
	}
	public void setTipDuga(TipDuga tipDuga) {
		this.tipDuga = tipDuga;
	}
	
	public void dodajRatu(Rata rata) {
		
	}
	
	public void dodajLiteraturu(Literatura literatura) {
		
	}
	
	public void dodajDug(Session session) {
		
	}
	
	public void urediDug(Session session) { // kad se izmiri dug potrebno je urediti to u bazi
		
	}
	
	
}
