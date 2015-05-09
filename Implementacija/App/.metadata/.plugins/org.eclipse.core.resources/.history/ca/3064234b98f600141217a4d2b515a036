package Entiteti;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;

import util.HibernateUtil;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Student s = new Student();
		s.setId(10);
		s.setIme("Faris");
		s.setPrezime("Dzafic");
		Session session = HibernateUtil.getSessionFactory().openSession();
		s.dodajStudenta(session);

	}

}
