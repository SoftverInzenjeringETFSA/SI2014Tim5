package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.Calendar;

public class Validacija {
	
	private static Validacija instanca = null;
	
	public Validacija() {}
	
	public static Validacija getInstance() {
		if(instanca == null) 
			instanca = new Validacija();
		return instanca;
	}

	public boolean passwordValidation(String pass)
	{
		if (pass.length()<8) return false;
		String passPattern = "^(.*[0-9].*[A-Z].*)|(.*[A-Z].*[0-9].*)$";
	java.util.regex.Pattern p = java.util.regex.Pattern.compile(passPattern);
	java.util.regex.Matcher m = p.matcher(pass);
	return m.matches();
	}
	
	/*public static boolean emailValidation(String email) {
		   boolean result = true;
		   try {
		      String emailAddr = new String(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}*/
	
	 public boolean emailValidation(String email) {
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(email);
         return m.matches();
  }
	
	 public boolean jmbgValidation(String jmbgTemp)
     {
         if ( jmbgTemp.length() == 13)
         {
             int[] danaUmjesecu = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
             String niz = jmbgTemp.substring(0,4);


             String godinaRodjenja = jmbgTemp.substring(4, 7); 
             int pomGodina = 100 * 	(Integer.parseInt(godinaRodjenja.substring(0, 0)))+
            		 		 10 * 	(Integer.parseInt(godinaRodjenja.substring(0, 1))) +
            		 		 		(Integer.parseInt(godinaRodjenja.substring(1, 2)));

             if (godinaRodjenja.substring(0, 1) == "0")
                 pomGodina += 2000;
             else
                 pomGodina += 1000; 

             if (pomGodina < 1900) 
                 return false;
             else
                 if (pomGodina > Calendar.getInstance().get(Calendar.YEAR)) 
                     return false;

             String mjesecRodjenja = jmbgTemp.substring(2, 4); 
             int pomMjesec = 10 * (	Integer.parseInt(mjesecRodjenja.substring(0, 1))) +
            		 				Integer.parseInt(mjesecRodjenja.substring(1, 1));
             if (pomMjesec > 12 || pomMjesec < 1) 
                 return false;
             
             
             if (((pomGodina % 4) == 0) && (((pomGodina % 100) != 0) || ((pomGodina % 400) == 0))) 
                 danaUmjesecu[1] = 29; 


             String danRodjenja = jmbgTemp.substring(0, 2);
             int pomDan = 10 * (Integer.parseInt(danRodjenja.substring(0, 1))) +
            		 			Integer.parseInt(danRodjenja.substring(1, 1));

             if (pomDan > danaUmjesecu[pomMjesec - 1] || pomDan < 1)
                 return false;

             int zbir = 0;

             for (int i = 0; i < 6; i++)
                 zbir += (7 - i) * (Integer.parseInt(niz.substring(i,i+1)) + Integer.parseInt(niz.substring(6 + i,7+i)));
             int ostatak = zbir % 11; 
             int razlika = 11 - ostatak; 

             if (ostatak == 1)
                 return false;
             else if (ostatak == 0) 
             {
                 if (Integer.parseInt(niz.substring(12, 13)) == 0)
                     return true;
                 else
                     return false;
             }
             else if (razlika == Integer.parseInt(niz.substring(12, 13)))
                 return true;
             else
                 return false;
         }
         else
             return false;
     }
	 
	 public boolean isbnValidation(String isbn)
     {
		 if ( isbn == null )
	        {
	            return false;
	        }
	        isbn = isbn.replaceAll( "-", "" );

	        if ( isbn.length() != 13 )
	        {
	            return false;
	        }

	        try
	        {
	            int tot = 0;
	            for ( int i = 0; i < 12; i++ )
	            {
	                int digit = Integer.parseInt( isbn.substring( i, i + 1 ) );
	                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
	            }

	            int checksum = 10 - (tot % 10);
	            if ( checksum == 10 )
	            {
	                checksum = 0;
	            }

	            return checksum == Integer.parseInt( isbn.substring( 12 ) );
	        }
	        catch ( NumberFormatException nfe )
	        {
	            return false;
	        }
     }
}