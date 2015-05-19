package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.persistence.Table;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import javax.swing.JButton;

import org.hibernate.Session;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UnosKorisnikaWindow {

	private JFrame frmUnosKorisnika;
	private static JTextField textField;
	private static  JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	
	
	private static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	static Korisnik k=new Korisnik();
	private static long id;
	
	static JButton btnUredi = new JButton("Uredi");
	static JButton btnDodaj = new JButton("Dodaj");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosKorisnikaWindow window = new UnosKorisnikaWindow();
					window.frmUnosKorisnika.setVisible(true);
					btnUredi.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(long _id,ArrayList<Korisnik> _korisnici) {
		korisnici=_korisnici;
		id=_id;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosKorisnikaWindow window = new UnosKorisnikaWindow();
					window.frmUnosKorisnika.setVisible(true);
					popuniPolja(id,korisnici);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		
		
		
	}

	/**
	 * Create the application.
	 */
	public UnosKorisnikaWindow() {
		initialize();
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosKorisnika = new JFrame();
		frmUnosKorisnika.setTitle("Unos korisnika");
		frmUnosKorisnika.setResizable(false);
		frmUnosKorisnika.setBounds(100, 100, 365, 328);
		frmUnosKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnosKorisnika.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("70px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("81px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("83px"),
				ColumnSpec.decode("79px"),},
			new RowSpec[] {
				RowSpec.decode("21px"),
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("35px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblIme = new JLabel("Ime:");
		frmUnosKorisnika.getContentPane().add(lblIme, "2, 2, right, center");
		
		textField = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField, "4, 2, 4, 1, fill, center");
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		frmUnosKorisnika.getContentPane().add(lblPrezime, "2, 4, right, center");
		
		textField_1 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_1, "4, 4, 4, 1, fill, center");
		textField_1.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		frmUnosKorisnika.getContentPane().add(lblJmbg, "2, 6, right, center");
		
		textField_5 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_5, "4, 6, 4, 1, fill, center");
		textField_5.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		frmUnosKorisnika.getContentPane().add(lblAdresa, "2, 8, right, center");
		
		textField_2 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_2, "4, 8, 4, 1, fill, center");
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		frmUnosKorisnika.getContentPane().add(lblEmail, "2, 10, right, center");
		
		textField_3 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_3, "4, 10, 4, 1, fill, center");
		textField_3.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		frmUnosKorisnika.getContentPane().add(lblTelefon, "2, 12, right, center");
		
		textField_4 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_4, "4, 12, 4, 1, fill, center");
		textField_4.setColumns(10);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		frmUnosKorisnika.getContentPane().add(lblKorisnikoIme, "2, 14, right, center");
		
		textField_6 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_6, "4, 14, 4, 1, fill, center");
		textField_6.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip:");
		frmUnosKorisnika.getContentPane().add(lblTip, "2, 16, right, center");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipKorisnika.values()));
		frmUnosKorisnika.getContentPane().add(comboBox, "4, 16, 4, 1, fill, center");
		
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_5.getText();
				String adresa = textField_2.getText();
				String mail = textField_3.getText();
				String telefon = textField_4.getText();
				String username = textField_6.getText();
				String lozinka = "lozinka";
				TipKorisnika tip;

				if(comboBox.getSelectedItem()=="Korisnik"){
					tip=TipKorisnika.values()[0];
				}
				else tip=TipKorisnika.values()[1];
			
				Korisnik k = new Korisnik(1, ime, prezime, jmbg, adresa, telefon, mail, tip, username, lozinka);
				
				try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				
					long id = k.dodajKorisnika(session);
					k.setId(id);
					korisnici.add(k);
					session.close();	
					
				    
				}
				
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getLocalizedMessage());
			    }
				
				
				
			}
		});
		frmUnosKorisnika.getContentPane().add(btnDodaj, "4, 18, center, center");
		
		
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_5.getText();
				String adresa = textField_2.getText();
				String mail = textField_3.getText();
				String telefon = textField_4.getText();
				String username = textField_6.getText();
				TipKorisnika tip;

				if(comboBox.getSelectedItem()=="Korisnik"){
					tip=TipKorisnika.values()[0];
				}
				else tip=TipKorisnika.values()[1];
							
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				
					long id = k.urediKorisnika(session);
					
					for (int i = 0; i < korisnici.size(); i++) {
						if(korisnici.get(i).getId()==id)
						{
						
							korisnici.get(i).setAdresa(adresa);
							korisnici.get(i).setId(id);
							korisnici.get(i).setIme(ime);
							korisnici.get(i).setJmbg(jmbg);
							korisnici.get(i).setMail(mail);
							korisnici.get(i).setPrezime(prezime);
							korisnici.get(i).setTelefon(telefon);
							korisnici.get(i).setTipKorisnika(tip);
							
						}
						
					session.close();	
				
			}
			}
		});
		
		frmUnosKorisnika.getContentPane().add(btnUredi, "6, 18, center, center");
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmUnosKorisnika.dispose();
			}
		});
		frmUnosKorisnika.getContentPane().add(btnIzai, "7, 18, right, center");
	}
	
	static void popuniPolja(long id,ArrayList<Korisnik> korisnici)
	{
		Korisnik k1=new Korisnik();
		for (int i = 0; i < korisnici.size(); i++) {
			if(korisnici.get(i).getId()==id)
			{
			
			k1=korisnici.get(i);
			}
		
			btnUredi.setVisible(true);
			btnDodaj.setVisible(false);
			textField.setText(k1.getIme());
			textField_1.setText(k1.getPrezime());
			textField_5.setText(k1.getJmbg());
			textField_2.setText(k1.getAdresa());
			textField_3.setText(k1.getMail());
			textField_4.setText(k1.getTelefon());
			}


	}
}
