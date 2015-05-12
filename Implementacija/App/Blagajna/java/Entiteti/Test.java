package Entiteti;

import org.hibernate.Session;

import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Literatura l = new Literatura(1, "asd", "asd", "asd", 1, 12.3);
		Session sess = HibernateUtil.getSessionFactory().openSession();
		l.dodajLiteraturu(sess);
		sess.close();
		System.out.println("dodano");
	}

}
