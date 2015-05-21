package ba.unsa.etf.si.tim5.blagajna.dodaci;

public class PorukaMail {
	private String naslov;
	private String poruka;
	private String mail;

	public PorukaMail() {

	}
	
	

	public String getNaslov() {
		return naslov;
	}



	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}



	public String getPoruka() {
		return poruka;
	}



	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public void postaviDugZaLiteraturu(String mail, String rok) {
		this.mail = mail;
		naslov = "Izmirenje duga za literaturu";
		poruka = "Niste izmirili svoje obaveze za literaturu, imate roka do "
				+ rok
				+ ". Ako do tada ne izmirite dugove, nećete moći pristupiti ispitima!";

	}

	public void postaviDugZaSkolarinu(String mail, String rok) {
		this.mail = mail;
		naslov = "Izmirenje duga za školarinu";
		poruka = "Niste izmirili svoje obaveze za literaturu, imate roka do "
				+ rok
				+ ". Ako do tada ne izmirite dugove, nećete moći pristupiti ispitima!";
		poruka += System.getProperty("line separator") + "Fakultet";
	}
}