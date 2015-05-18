package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;


public class Dao {
	private static Dao instanca = null;
	
	public static Dao getInstance() {
		if(instanca == null) 
			instanca = new Dao();
		return instanca;
	}
	
	public Dao() {
		
	}
	
	public ArrayList<Student> dajSveStudente() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Student> l = (ArrayList<Student>)session.createSQLQuery("SELECT * FROM student").addEntity(Student.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	
	
	
}
