package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;

import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Utility;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

import java.awt.Choice;
import java.awt.Button;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;

public class UnosWindow {	
	JFrame frmUnosStudenta;
	private JTextField tFieldIme;
	private JTextField tFieldMjestoRodj;
	private JTextField tFieldPrezime;
	private JTextField tFieldRoditelj;
	private JTextField tFieldTelefon;
	private JTextField tFieldJmbg;
	private JTextField tFieldOpcina;
	private JTextField tFieldDrzava;
	private JTextField tFieldAdresaPreb;
	private JTextField tFieldOpcinaPreb;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField tFieldIndeks;
	private JTextField tFieldTroskovi;
	private JLabel lblGodinaKojuUpisje;
	private JLabel lblPopust;
	private JTextField tFieldPopust;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;
	private JButton btnUnesi;
	private JLabel lblKm;
	private JComboBox cBoxGodina;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblEmail;
	private JTextField tFieldMail;
	private JLabel lblUkupniTrokovi;
	private JLabel lblcijena;
	final static Logger logger = Logger.getLogger(UnosKorisnikaWindow.class);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosWindow window = new UnosWindow();
					window.frmUnosStudenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosWindow() {
		initialize();			
	}	
	
	private ArrayList<Student> studenti;
	private Student student;
	public UnosWindow(ArrayList<Student> studenti) {
		initialize();
		this.studenti = studenti;
	}
	public UnosWindow(Student student) {
		initialize();
		this.student = student;	
		this.btnUnesi.setText("Uredi");
		this.chckbxNewCheckBox.setContentAreaFilled(true);
		popuniPolja();
		chckbxNewCheckBox.setVisible(false);
	}	
	
	private void popuniPolja() {
		this.tFieldIme.setText(student.getIme());
		this.tFieldPrezime.setText(student.getPrezime()); 
	    this.tFieldRoditelj.setText(student.getImeRoditelja());
	    this.tFieldTelefon.setText(student.getTelefon());
		this.tFieldJmbg.setText(student.getJmbg());
		this.tFieldMjestoRodj.setText(student.getMjestoRodjenja());
		this.tFieldOpcina.setText(student.getOpcinaRodjenja());
		this.tFieldDrzava.setText(student.getDrzavaRodjenja());
		this.tFieldAdresaPreb.setText(student.getAdresa());
		this.tFieldOpcinaPreb.setText(student.getOpcina());
		this.tFieldMail.setText(student.getMail());
		this.tFieldIndeks.setText(Integer.toString(student.getIndeks()));
		this.cBoxGodina.setSelectedItem(student.getGodinaStudija());
		this.tFieldTroskovi.setText(String.valueOf(student.getTroskoviSkolarine()));
		this.tFieldPopust.setText(String.valueOf(student.getPopust()));
				
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosStudenta = new JFrame();
		frmUnosStudenta.setTitle("Unos studenta");
		frmUnosStudenta.setResizable(false);
		frmUnosStudenta.setBounds(100, 100, 779, 407);
		frmUnosStudenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmUnosStudenta.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("326px"),
					ColumnSpec.decode("337px"),
					ColumnSpec.decode("91px"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("185px"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("136px"),
					FormFactory.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("23px"),}));
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Lični podaci"));
			frmUnosStudenta.getContentPane().add(panel, "2, 2, 3, 1, fill, fill");
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(116dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(126dlu;default):grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			
				
				JLabel lblNewLabel = new JLabel("Ime:");
				
				panel.add(lblNewLabel, "2, 2");
				
				tFieldIme = new JTextField();
				panel.add(tFieldIme, "4, 2");
				tFieldIme.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Mjesto ro\u0111enja:");
				panel.add(lblNewLabel_2, "8, 2");
				
				tFieldMjestoRodj = new JTextField();
				panel.add(tFieldMjestoRodj, "10, 2");
				tFieldMjestoRodj.setColumns(10);
				
				JLabel lblPrezime = new JLabel("Prezime:");
				panel.add(lblPrezime, "2, 4");
				
				tFieldPrezime = new JTextField();
				panel.add(tFieldPrezime, "4, 4, default, top");
				tFieldPrezime.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("Op\u0107ina ro\u0111enja:");
				panel.add(lblNewLabel_3, "8, 4");
				
				tFieldOpcina = new JTextField();
				panel.add(tFieldOpcina, "10, 4");
				tFieldOpcina.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Ime roditelja:");
				panel.add(lblNewLabel_1, "2, 6");
				
				tFieldRoditelj = new JTextField();
				panel.add(tFieldRoditelj, "4, 6");
				tFieldRoditelj.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Dr\u017Eava ro\u0111enja:");
				panel.add(lblNewLabel_4, "8, 6");
				
				tFieldDrzava = new JTextField();
				panel.add(tFieldDrzava, "10, 6");
				tFieldDrzava.setColumns(10);
				
				JLabel lblBrojTelefona = new JLabel("Broj telefona:");
				panel.add(lblBrojTelefona, "2, 8");
				
				tFieldTelefon = new JTextField();
				panel.add(tFieldTelefon, "4, 8");
				tFieldTelefon.setColumns(10);
				
				JLabel lblAdresaPrebivalita = new JLabel("Adresa prebivali\u0161ta:");
				panel.add(lblAdresaPrebivalita, "8, 8");
				
				tFieldAdresaPreb = new JTextField();
				panel.add(tFieldAdresaPreb, "10, 8");
				tFieldAdresaPreb.setColumns(10);
				
				JLabel lblJmbg = new JLabel("JMBG:");
				panel.add(lblJmbg, "2, 10");
				
				tFieldJmbg = new JTextField();
				panel.add(tFieldJmbg, "4, 10");
				tFieldJmbg.setColumns(10);
				
				JLabel lblOpinaPrebivalita = new JLabel("Op\u0107ina prebivali\u0161ta:");
				panel.add(lblOpinaPrebivalita, "8, 10");
				
				tFieldOpcinaPreb = new JTextField();
				panel.add(tFieldOpcinaPreb, "10, 10");
				tFieldOpcinaPreb.setColumns(10);
				
				lblEmail = new JLabel("E-Mail:");
				panel.add(lblEmail, "8, 12, right, default");
				
				tFieldMail = new JTextField();
				tFieldMail.setColumns(10);
				panel.add(tFieldMail, "10, 12, fill, default");
				
				panel_1 = new JPanel();
				panel_1.setBorder(BorderFactory.createTitledBorder("Podaci o studiju"));
				frmUnosStudenta.getContentPane().add(panel_1, "2, 4, 3, 1, fill, fill");
				panel_1.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(104dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,}));
				
				lblNewLabel_5 = new JLabel("Broj indeksa:");
				panel_1.add(lblNewLabel_5, "2, 2, right, default");
				
				tFieldIndeks = new JTextField();
				panel_1.add(tFieldIndeks, "4, 2, left, default");
				tFieldIndeks.setColumns(10);
				
				lblNewLabel_6 = new JLabel("Tro\u0161kovi strudija:");
				panel_1.add(lblNewLabel_6, "8, 2, right, default");
				
				tFieldTroskovi = new JTextField();
				panel_1.add(tFieldTroskovi, "10, 2, 3, 1, fill, default");
				tFieldTroskovi.setColumns(10);
				
				lblKm = new JLabel("KM");
				panel_1.add(lblKm, "14, 2");
				
				lblGodinaKojuUpisje = new JLabel("Godina koju upisje:");
				panel_1.add(lblGodinaKojuUpisje, "2, 4, right, default");
				
				cBoxGodina = new JComboBox();
				cBoxGodina.setModel(new DefaultComboBoxModel(GodinaStudija.values()));
				panel_1.add(cBoxGodina, "4, 4, fill, default");
				
				lblPopust = new JLabel("Popust:");
				panel_1.add(lblPopust, "8, 4, right, default");
				
				tFieldPopust = new JTextField();
				panel_1.add(tFieldPopust, "10, 4, 3, 1, fill, default");
				tFieldPopust.setColumns(10);
				
				lblNewLabel_7 = new JLabel("%");
				panel_1.add(lblNewLabel_7, "14, 4");
				
				chckbxNewCheckBox = new JCheckBox("Prvi put se unosi u sistem:");
				panel_1.add(chckbxNewCheckBox, "4, 6");
				
				lblUkupniTrokovi = new JLabel("Ukupni tro\u0161kovi:");
				panel_1.add(lblUkupniTrokovi, "8, 6, right, default");
				
				lblcijena = new JLabel("{cijena KM}");
				panel_1.add(lblcijena, "10, 6, left, default");
				
				btnUnesi = new JButton("Unesi");
				btnUnesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = tFieldIme.getText();
						String prezime = tFieldPrezime.getText();
						String roditelj = tFieldRoditelj.getText();
						String telefon = tFieldTelefon.getText();
						String jmbg = tFieldJmbg.getText();
						String mjestoRodj = tFieldMjestoRodj.getText();
						String opcinaRodj = tFieldOpcina.getText();
						String drzava = tFieldDrzava.getText();
						String adresaPreb = tFieldAdresaPreb.getText();
						String opcinaPreb = tFieldOpcinaPreb.getText();
						String mail = tFieldMail.getText();
						int indeks =  Integer.parseInt(tFieldIndeks.getText());
						GodinaStudija godinaUpisa = (GodinaStudija)cBoxGodina.getSelectedItem();
						double troskovi = Double.parseDouble(tFieldTroskovi.getText());
						double popust =  Double.parseDouble(tFieldPopust.getText());
						double cijena  = troskovi - (troskovi * popust /100);
						Student s;
						try {
						s = new Student(1, ime, prezime, jmbg,
								mail, adresaPreb, opcinaPreb, telefon,
								indeks, troskovi, roditelj, mjestoRodj, opcinaRodj,
							    drzava, popust, godinaUpisa);
						s.setTroskoviSkolarine(cijena);
						s.setPopust(popust);
						}catch(IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(null, "Problem:"+ ex.getMessage(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);							//
							logger.error("Greška kod dodavanja novog studenta! " + ex.getMessage() , ex);
							return;
						}
						
						try {
							
						Session session = HibernateUtil.getSessionFactory().openSession();
											
						String godina =  Utility.getInstance().dajStudijskuGodinu();
						if(chckbxNewCheckBox.isSelected()) {							
							long id = s.dodajStudenta(session);
							JOptionPane.showMessageDialog(null, "Student je dodan!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
							Dug d = new Dug(1, false, godina,
									s.dajDugZaSkolarinu(), s.getId(), TipDuga.dugZaSkolarinu);
							d.dodajDug(session);
							lblcijena.setText(String.valueOf(cijena));							
							s.setId(id);
							studenti.add(s);							
						}
						else {							
							s.urediStudenta(session);
							JOptionPane.showMessageDialog(null, "Student je uređen!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
							Dug d = new Dug(1, false, "2014/2015",
									s.dajUkupniDug(), s.getId(), TipDuga.dugZaSkolarinu);
							d.dodajDug(session);							
						}
						
						session.close();	
						}catch(ConstraintViolationException cve) {
							JOptionPane.showMessageDialog(null, cve.getConstraintName(),"Problem",JOptionPane.INFORMATION_MESSAGE);
							logger.error("Pokušaj unosa već postojeće literature", cve );	
							return;
						} catch (Exception ex) {
							return;
						}
					
				}});
				frmUnosStudenta.getContentPane().add(btnUnesi, "2, 6, fill, top");
				
				btnNewButton_1 = new JButton("Iza\u0111i");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frmUnosStudenta.setVisible(false); //you can't see me!
						frmUnosStudenta.dispose();
					}
				});
				frmUnosStudenta.getContentPane().add(btnNewButton_1, "4, 6, right, top");
	}

}
