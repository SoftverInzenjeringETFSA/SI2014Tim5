package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;

public class Validacija {

	private static Validacija instanca = null;

	public Validacija() {
	}

	public static Validacija getInstance() {
		if (instanca == null)
			instanca = new Validacija();
		return instanca;
	}

	public boolean passwordValidation(String pass) {
		if (pass.length() < 8)
			return false;
		String passPattern = "^(.*[0-9].*[A-Z].*)|(.*[A-Z].*[0-9].*)$";
		java.util.regex.Pattern p = java.util.regex.Pattern
				.compile(passPattern);
		java.util.regex.Matcher m = p.matcher(pass);
		return m.matches();
	}

	/*
	 * public static boolean emailValidation(String email) { boolean result =
	 * true; try { String emailAddr = new String(email); emailAddr.validate(); }
	 * catch (AddressException ex) { result = false; } return result; }
	 */

	public static boolean emailValidation(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	/*public static boolean jmbgValidation(String jmbgTemp) {
		if (jmbgTemp.length() == 13) {
			int[] danaUmjesecu = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
					31 };
			String niz = jmbgTemp.substring(0, 4);

			String godinaRodjenja = jmbgTemp.substring(4, 7);
			int pomGodina = 100
					* (Integer.parseInt(godinaRodjenja.substring(0, 0))) + 10
					* (Integer.parseInt(godinaRodjenja.substring(0, 1)))
					+ (Integer.parseInt(godinaRodjenja.substring(1, 2)));

			if (godinaRodjenja.substring(0, 1) == "0")
				pomGodina += 2000;
			else
				pomGodina += 1000;

			if (pomGodina < 1900)
				return false;
			else if (pomGodina > Calendar.getInstance().get(Calendar.YEAR))
				return false;

			String mjesecRodjenja = jmbgTemp.substring(2, 4);
			int pomMjesec = 10
					* (Integer.parseInt(mjesecRodjenja.substring(0, 1)))
					+ Integer.parseInt(mjesecRodjenja.substring(1, 1));
			if (pomMjesec > 12 || pomMjesec < 1)
				return false;

			if (((pomGodina % 4) == 0)
					&& (((pomGodina % 100) != 0) || ((pomGodina % 400) == 0)))
				danaUmjesecu[1] = 29;

			String danRodjenja = jmbgTemp.substring(0, 2);
			int pomDan = 10 * (Integer.parseInt(danRodjenja.substring(0, 1)))
					+ Integer.parseInt(danRodjenja.substring(1, 1));

			if (pomDan > danaUmjesecu[pomMjesec - 1] || pomDan < 1)
				return false;

			int zbir = 0;

			for (int i = 0; i < 6; i++)
				zbir += (7 - i)
						* (Integer.parseInt(niz.substring(i, i + 1)) + Integer
								.parseInt(niz.substring(6 + i, 7 + i)));
			int ostatak = zbir % 11;
			int razlika = 11 - ostatak;

			if (ostatak == 1)
				return false;
			else if (ostatak == 0) {
				if (Integer.parseInt(niz.substring(12, 13)) == 0)
					return true;
				else
					return false;
			} else if (razlika == Integer.parseInt(niz.substring(12, 13)))
				return true;
			else
				return false;
		} else
			return false;
	}*/
	
	public boolean validirajJmbg(String jmbg) {
		Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$"); 
		Matcher matcher = pattern.matcher(jmbg);
	    if (matcher.matches()) return true;
	    else return false;
	}

	public boolean isbnValidation(String isbn) {
		if (isbn == null) {
			return false;
		}
		isbn = isbn.replaceAll("-", "");

		if (isbn.length() != 13) {
			return false;
		}

		try {
			int tot = 0;
			for (int i = 0; i < 12; i++) {
				int digit = Integer.parseInt(isbn.substring(i, i + 1));
				tot += (i % 2 == 0) ? digit * 1 : digit * 3;
			}

			int checksum = 10 - (tot % 10);
			if (checksum == 10) {
				checksum = 0;
			}

			return checksum == Integer.parseInt(isbn.substring(12));
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	
	
	
	
	public Boolean validirajUsername(String t) {
		if (t.length()<4 ) return false;
		if (t.length() > 35) return false;
		return true;
	}
	
	
	public Boolean validirajTelefon(String t)
	{
		Pattern pattern = Pattern.compile("\\d{3}/\\d{3}-\\d{3}");
	    Matcher matcher = pattern.matcher(t);
	    if (matcher.matches()) return true;
	    else return false;
	}
	
	public Boolean validirajAdresu(String t) {
		if (t.length() > 44) return false;
		if (t.length() < 4 ) return false;
		return true;
	}
	
	public Boolean validirajMail(String t)
	{
		if (t.length() > 35) return false;
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(t);
		if (matcher.matches()) return true;
		else return false;
	}
	
	public Boolean validirajIme(String ime) {
		if (ime.length() > 30) return false;
		else if(ime.length() <2) return false;
		Pattern pattern = Pattern.compile("^[A-Z|Č|Ć|Ž|Š|Đ]{1}[a-z|č|ć|ž|š|đ]{2,}$");
		Matcher matcher = pattern.matcher(ime);
		if (matcher.matches())	return true;
		else return false;
	}
	
	
	
	public Boolean validirajIsto(String jmbg,String telefon,String mail,String username) {
		
		ArrayList<Korisnik>korisnici= Dao.getInstance().dajSveKorisnike();
		for(int i=0;i<korisnici.size();i++)
		{
			if(username==korisnici.get(i).getKorisnickoIme()){
				throw new IllegalArgumentException("Korisnicko ime vec postoji!");
			}	
			if(jmbg==korisnici.get(i).getJmbg()){ 
				throw new IllegalArgumentException("JMBG vec postoji!");
			}
			if(telefon==korisnici.get(i).getTelefon()){
				throw new IllegalArgumentException("Telefon vec postoji!");
			}
			if(mail==korisnici.get(i).getMail()){
				throw new IllegalArgumentException("Mail vec postoji!");
			}
		}
		return true;
	}
	
	
	public Boolean validirajTekst(String tekst) {
		if (tekst.length() > 30) return false;
		else if(tekst.length() <2) return false;
		Pattern pattern = Pattern.compile("^[A-Z|Č|Ć|Ž|Š|Đ]{1}[a-z|č|ć|ž|š|đ ]{2,}$");
		Matcher matcher = pattern.matcher(tekst);
		if (matcher.matches())	return true;
		else return false;
	}
	
	
}
