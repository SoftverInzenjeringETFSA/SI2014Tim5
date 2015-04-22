package Entiteti;

public abstract class Osoba {


	private String prezime;
	private String jmbg;
	private String mail;
	private String adresa;
	private String opcina;
	private String telefon;
	
	public Osoba() {}
	
	
	public Osoba(String prezime, String jmbg, String mail, String adresa,
			String opcina, String telefon, String ime) {
		super();
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.mail = mail;
		this.adresa = adresa;
		this.opcina = opcina;
		this.telefon = telefon;
		this.ime = ime;
	}


	private String ime;
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

	//region GetSet
	
	@Override
	public String toString() {
		return ime +  prezime;
	}
	
}
