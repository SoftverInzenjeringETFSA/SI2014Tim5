package ba.unsa.etf.si.tim5.blagajna.dodaci;

import java.util.ArrayList;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
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
	
	public ArrayList<Dug> dajSveDugove(String querry) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery(querry).addEntity(Dug.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	
	
	public ArrayList<Dug> dajSveDugove() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM Dug").addEntity(Dug.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	
	public ArrayList<Dug> dajSveDugovePoTipu(TipDuga tip) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Dug> l = (ArrayList<Dug>)session.createSQLQuery("SELECT * FROM Dug where tipduga = "+tip + ";").addEntity(Dug.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	
	public ArrayList<Korisnik> dajSveKorisnike() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Korisnik> l = (ArrayList<Korisnik>)session.createSQLQuery("SELECT * FROM korisnik").addEntity(Korisnik.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	
	public Student dajStudentaPoJMBG(String jmbg) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Student> l = (ArrayList<Student>)session.createSQLQuery("SELECT * FROM student where jmbg='"+jmbg +"'").addEntity(Student.class).list();		
		t.commit();	
		session.close();
		return l.get(0);
	}
	
	public ArrayList<Literatura> dajSvuLiteraturu() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Literatura> l = (ArrayList<Literatura>)session.createSQLQuery("SELECT * FROM literatura").addEntity(Literatura.class).list();		
		t.commit();	
		session.close();
		return l;
	}
	 
	public Literatura dajLiteraturuPoId(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		Literatura l = (Literatura)session.get(Literatura.class, id);		
		t.commit();	
		session.close();
		return l;
	}
	
	public Korisnik dajKorisnikaPoId(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		Korisnik l = (Korisnik)session.get(Korisnik.class, id);		
		t.commit();	
		session.close();
		return l;
	}
	
	
}
