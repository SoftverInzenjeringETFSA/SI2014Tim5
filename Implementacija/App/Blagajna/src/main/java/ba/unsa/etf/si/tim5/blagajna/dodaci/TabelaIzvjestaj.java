package ba.unsa.etf.si.tim5.blagajna.dodaci;



public class TabelaIzvjestaj {
	private String indeks;
	private String student;
	private double Troskovi;
	private double dug;
	private String mozePolagati; 
	
	public TabelaIzvjestaj() {}

	public TabelaIzvjestaj(int indeks, String student, double troskovi,
			double dug, MozePolagati mozePolagati) {
		super();
		this.indeks = String.valueOf(indeks);
		this.student = student;
		Troskovi = troskovi;
		this.dug = dug;
		this.mozePolagati = mozePolagati.toString();
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
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
