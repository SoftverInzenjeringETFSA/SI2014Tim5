package ba.unsa.etf.si.tim5.blagajna.dodaci;



public class TabelaIzvjestaj {
	private int indeks;
	private String student;
	private double Troskovi;
	private double dug;
	private String mozePolagati; 
	
	public TabelaIzvjestaj() {}

	public TabelaIzvjestaj(int indeks, String student, double troskovi,
			double dug, MozePolagati mozePolagati) {
		super();
		this.indeks = indeks;
		this.student = student;
		Troskovi = troskovi;
		this.dug = dug;
		this.mozePolagati = mozePolagati.toString();
	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public double getTroskovi() {
		return Troskovi;
	}

	public void setTroskovi(double troskovi) {
		Troskovi = troskovi;
	}

	public double getDug() {
		return dug;
	}

	public void setDug(double dug) {
		this.dug = dug;
	}

	public String getMozePolagati() {
		return mozePolagati;
	}

	public void setMozePolagati(String mozePolagati) {
		this.mozePolagati = mozePolagati;
	}
	
	
}
