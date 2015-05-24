package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Validacija;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.apache.log4j.Logger;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UnosKorisnikaWindow {
	final static Logger logger = Logger.getLogger(UnosKorisnikaWindow.class);
	
	JFrame frmUnosKorisnika;
	
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;

	private ArrayList<Korisnik> korisnici;
	private Korisnik k;
//	private long id;
	private JTable tabela;
	protected Component frame;
	private int selektovani;
	static JButton btnUredi = new JButton("Uredi");
	static JButton btnDodaj = new JButton("Dodaj");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//@Override
			
			public void run() {
				try {
					UnosKorisnikaWindow window = new UnosKorisnikaWindow();
					window.frmUnosKorisnika.setVisible(true);
					btnUredi.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getMessage(), e);
					//logger.error("Greška pri otvaranju forme za unos korisnika! " + e.getMessage() , e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosKorisnikaWindow() {
		initialize();
		btnUredi.setVisible(false);
	}

	public UnosKorisnikaWindow(Korisnik _k, JTable tabela, int selektovani) {
		k = _k;
		initialize();
		popuniPolja(k);
		this.tabela = tabela;	
		this.selektovani = selektovani;
		btnDodaj.setVisible(false);
	}

	public UnosKorisnikaWindow(ArrayList<Korisnik> korisnici, JTable tabela) {
		initialize();
		this.korisnici = korisnici;
		btnUredi.setVisible(false);
		this.tabela = tabela;	
		btnDodaj.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosKorisnika = new JFrame();
		frmUnosKorisnika.setTitle("Unos korisnika");
		frmUnosKorisnika.setResizable(false);
		frmUnosKorisnika.setBounds(100, 100, 365, 328);
		frmUnosKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUnosKorisnika.getContentPane().setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.UNRELATED_GAP_COLSPEC,
								ColumnSpec.decode("70px"),
								FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
								ColumnSpec.decode("81px"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("83px"),
								ColumnSpec.decode("79px"), }, new RowSpec[] {
								RowSpec.decode("21px"), RowSpec.decode("20px"),
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
								RowSpec.decode("20px"), RowSpec.decode("35px"),
								RowSpec.decode("23px"), }));

		JLabel lblIme = new JLabel("Ime:");
		frmUnosKorisnika.getContentPane().add(lblIme, "2, 2, right, center");

		textField = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField,
				"4, 2, 4, 1, fill, center");
		textField.setColumns(10);

		JLabel lblPrezime = new JLabel("Prezime:");
		frmUnosKorisnika.getContentPane()
				.add(lblPrezime, "2, 4, right, center");

		textField_1 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_1,
				"4, 4, 4, 1, fill, center");
		textField_1.setColumns(10);

		JLabel lblJmbg = new JLabel("JMBG:");
		frmUnosKorisnika.getContentPane().add(lblJmbg, "2, 6, right, center");

		textField_5 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_5,
				"4, 6, 4, 1, fill, center");
		textField_5.setColumns(10);

		JLabel lblAdresa = new JLabel("Adresa:");
		frmUnosKorisnika.getContentPane().add(lblAdresa, "2, 8, right, center");

		textField_2 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_2,
				"4, 8, 4, 1, fill, center");
		textField_2.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		frmUnosKorisnika.getContentPane().add(lblEmail, "2, 10, right, center");

		textField_3 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_3,
				"4, 10, 4, 1, fill, center");
		textField_3.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon:");
		frmUnosKorisnika.getContentPane().add(lblTelefon,
				"2, 12, right, center");

		textField_4 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_4,
				"4, 12, 4, 1, fill, center");
		textField_4.setColumns(10);

		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		frmUnosKorisnika.getContentPane().add(lblKorisnikoIme,
				"2, 14, right, center");

		textField_6 = new JTextField();
		frmUnosKorisnika.getContentPane().add(textField_6,
				"4, 14, 4, 1, fill, center");
		textField_6.setColumns(10);

		JLabel lblTip = new JLabel("Tip:");
		frmUnosKorisnika.getContentPane().add(lblTip, "2, 16, right, center");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipKorisnika.values()));
		frmUnosKorisnika.getContentPane().add(comboBox,
				"4, 16, 4, 1, fill, center");

		btnDodaj.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {

				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_5.getText();
				String adresa = textField_2.getText();
				String mail = textField_3.getText();
				String telefon = textField_4.getText();
				String username = textField_6.getText();
<<<<<<< HEAD
				String lozinka = "admin";
				//boolean pomocna;
				
=======
				String lozinka = "admin";			
>>>>>>> 8cb09ec5f555e347ad79535662d0ba04e7bb5c5c
				
				TipKorisnika tip = (TipKorisnika) comboBox.getSelectedItem();
				
				try {
					Session session = HibernateUtil.getSessionFactory()
							.openSession();
					
<<<<<<< HEAD
					
					 k = new Korisnik(1, ime, prezime, jmbg, adresa,
=======
					//if(!Validacija.getInstance().validirajIsto(jmbg, telefon, mail, username)) throw new IllegalArgumentException();
					//else {
					Korisnik k = new Korisnik(1, ime, prezime, jmbg, adresa,
>>>>>>> 8cb09ec5f555e347ad79535662d0ba04e7bb5c5c
							telefon, mail, tip, username, lozinka);
					
					k.dodajKorisnika(session);
					JOptionPane.showMessageDialog(frame,
							"Dodali ste novog korisnika " + ime + " " + prezime
									+ ".");
					logger.info("Dodali ste novog korisnika " + k.getIme() + " " + k.getPrezime()+".");
					session.close();
					DefaultTableModel tmodel = (DefaultTableModel) tabela.getModel();
					tmodel.addRow(new Object[] { k.getId(), k.getIme(),
							k.getPrezime(), k.getJmbg(), k.getAdresa(),
							k.getTelefon(), k.getMail(), k.getTipKorisnika() });
				//	}
					
				}
				
				
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							ex.getLocalizedMessage());
					ex.printStackTrace();
					logger.error("Greška kod dodavanja novog korisnika! " + ex.getMessage() , ex);
					
				}
				

			}
		});
		frmUnosKorisnika.getContentPane()
				.add(btnDodaj, "4, 18, center, center");

		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_5.getText();
				String adresa = textField_2.getText();
				String mail = textField_3.getText();
				String telefon = textField_4.getText();
				String username = textField_6.getText();
				TipKorisnika tip = (TipKorisnika) comboBox.getSelectedItem();

				try {
					Session session = HibernateUtil.getSessionFactory()
							.openSession();
					if(!Validacija.getInstance().validirajIsto(jmbg,telefon,mail,username)) throw new IllegalArgumentException();
					k = new Korisnik(k.getId(), ime, prezime, jmbg, adresa,
							telefon, mail, tip, username, "admin");
					
					k.urediKorisnika(session);
					JOptionPane.showMessageDialog(frame,
							"Uredili ste korisnika " + ime + " " + prezime
									+ "!");
					logger.info("Uredili ste korisnika " + k.getIme() + " " + k.getPrezime()+".");
					session.close();
					DefaultTableModel tmodel = (DefaultTableModel) tabela.getModel();
					tmodel.setValueAt(k.getId(), selektovani, 0);
					tmodel.setValueAt(k.getIme(), selektovani, 1);
					tmodel.setValueAt(k.getPrezime(), selektovani, 2);
					tmodel.setValueAt(k.getJmbg(), selektovani, 3);
					tmodel.setValueAt(k.getAdresa(), selektovani, 4);
					tmodel.setValueAt(k.getTelefon(), selektovani, 5);
					tmodel.setValueAt(k.getMail(), selektovani, 6);
					tmodel.setValueAt(k.getTipKorisnika(), selektovani, 7);

				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							ex.getLocalizedMessage());
					logger.error("Greška kod uredjivanja novog korisnika! " + ex.getMessage() , ex);
				}

			}
		});

		frmUnosKorisnika.getContentPane()
				.add(btnUredi, "6, 18, center, center");

		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				frmUnosKorisnika.dispose();
			}
		});
		frmUnosKorisnika.getContentPane().add(btnIzai, "7, 18, right, center");
	}

	protected static void popuniPolja(Korisnik k) {

		btnUredi.setVisible(true);
		btnDodaj.setVisible(false);
		textField.setText(k.getIme());
		textField_1.setText(k.getPrezime());
		textField_5.setText(k.getJmbg());
		textField_2.setText(k.getAdresa());
		textField_3.setText(k.getMail());
		textField_4.setText(k.getTelefon());
	}

}
