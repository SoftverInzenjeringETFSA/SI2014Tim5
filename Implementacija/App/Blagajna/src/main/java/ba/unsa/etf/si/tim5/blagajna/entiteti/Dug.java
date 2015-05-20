package ba.unsa.etf.si.tim5.blagajna.entiteti;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

public class Dug implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6950513813519064755L;
	private long id;
	private boolean jeLiIzmiren;
	private String akademskaGodina;
	double vrijednost;
	private long studentId;
	private TipDuga tipDuga;
	private long literaturaId;

	public Dug() {
	}

	public Dug(long id, boolean jeLiIzmiren, String akademskaGodina,
			double vrijednost, long studentId, TipDuga tipDuga) {
		super();
		this.id = id;
		this.jeLiIzmiren = jeLiIzmiren;
		this.akademskaGodina = akademskaGodina;
		this.vrijednost = vrijednost;
		this.studentId = studentId;
		this.tipDuga = tipDuga;
	}

	public Dug(long id, boolean jeLiIzmiren, String akademskaGodina,
			double vrijednost, long studentId, TipDuga tipDuga,
			long literaturaId) {
		super();
		this.id = id;
		this.jeLiIzmiren = jeLiIzmiren;
		this.akademskaGodina = akademskaGodina;
		this.vrijednost = vrijednost;
		this.studentId = studentId;
		this.tipDuga = tipDuga;
		this.literaturaId = literaturaId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isJeLiIzmiren() {
		return jeLiIzmiren;
	}

	public void setJeLiIzmiren(boolean jeLiIzmiren) {
		this.jeLiIzmiren = jeLiIzmiren;
	}

	public String getAkademskaGodina() {
		return akademskaGodina;
	}

	public void setAkademskaGodina(String akademskaGodina) {
		this.akademskaGodina = akademskaGodina;
	}

	public double getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getLiteraturaId() {
		return literaturaId;
	}

	public void setLiteraturaId(long literaturaId) {
		this.literaturaId = literaturaId;
	}

	public TipDuga getTipDuga() {
		return tipDuga;
	}

	public void setTipDuga(TipDuga tipDuga) {
		this.tipDuga = tipDuga;
	}

	public ArrayList<Rata> dajSveRate(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		ArrayList<Rata> l = (ArrayList<Rata>) session
				.createSQLQuery(
						"SELECT * FROM rata where dugId = " + this.id + ";")
				.addEntity(Rata.class).list();
		t.commit();
		return l;

	}

	public double dajVrijednostDuga() { 
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();
		int uplacena = 0;
		ArrayList<Rata> l = (ArrayList<Rata>)session.createSQLQuery("SELECT * FROM Rata where dugid = "+ String.valueOf(this.id) + "and jeliuplacena = "+String.valueOf(uplacena)).addEntity(Rata.class).list();		
		t.commit();	
		session.close();
		double dug = 0;
		for(int i = 0; i<l.size(); i++) dug += l.get(i).getVrijednost();
		return dug;
		
	}

	public Student dajStudenta() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		org.hibernate.Transaction t = session.beginTransaction();		
		ArrayList<Student> l = (ArrayList<Student>)session.createSQLQuery("SELECT * FROM student where studentId = "+ String.valueOf(this.studentId)).addEntity(Student.class).list();		
		t.commit();	
		session.close();
		return l.get(0);
	}
	private Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public long dodajDug(Session session) {
		org.hibernate.Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		t.commit();
		Rata r1 = new Rata(1, this.vrijednost / 4, false, new Date(), null,
				addDays(new Date(), 90), this.id);
		Rata r2 = new Rata(1, this.vrijednost / 4, false, new Date(), null,
				addDays(new Date(), 90), this.id);
		Rata r3 = new Rata(1, this.vrijednost / 4, false, new Date(), null,
				addDays(new Date(), 90), this.id);
		Rata r4 = new Rata(1, this.vrijednost / 4, false, new Date(), null,
				addDays(new Date(), 90), this.id);
		r1.dodajRatu(session);
		r2.dodajRatu(session);
		r3.dodajRatu(session);
		r4.dodajRatu(session);
		return id;
	}

	public void urediDug(Session session) { // kad se izmiri dug potrebno je
											// urediti to u bazi
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(this);
		t.commit();
	}

}
