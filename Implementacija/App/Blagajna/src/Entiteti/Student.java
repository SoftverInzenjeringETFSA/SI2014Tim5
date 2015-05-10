package Entiteti;

public class Student extends Osoba {
	private int indeks;
	private double troskoviSkolarine;
	private double troskoviLiterature;
	private String imeRoditelja;
	private String mjestoRodjenja;
	private String opcinaRodjenja;
	private String drzavaRodjenja;
	private double popust;
	private int godinaStudija;
	
	public Student() {}
	public Student(int id, String prezime, String jmbg, String mail, String adresa,
			String opcina, String telefon, String ime, int indeks, double troskoviSkolarine,
			double troskoviLiterature, String imeRoditelja,
			String mjestoRodjenja, String opcinaRodjenja,
			String drzavaRodjenja, double popust, int godinaStudija) {
		super(id, ime, prezime, jmbg, mail, adresa, opcina, telefon);
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
	
	public Object[] dajPodatkeZaPrikaz() {
		return new Object[] {this.getId() , this.toString(), this.getIndeks(), this.getTroskoviSkolarine(), this.getTroskoviLiterature() };
	}
	
}
