package ba.unsa.etf.si.tim5.blagajna.entiteti;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Literatura l = new Literatura(8, "xxx", "asd", "asd", 1, 42.3);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		l.dodajLiteraturu(session);
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(l);
		t.commit();
		session.close();
		
		System.out.println("izmjenjeno");
	}
}
