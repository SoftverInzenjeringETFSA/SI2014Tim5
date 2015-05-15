package ba.unsa.etf.si.tim5.blagajna.entiteti;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Literatura l = new Literatura(1, "asd", "asd", "asd", 1, 12.3);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//l.dodajLiteraturu(sess);
		org.hibernate.Transaction t = session.beginTransaction();
		session.save(l);
		t.commit();
		session.close();
		
		System.out.println("dodano");
	}

}
