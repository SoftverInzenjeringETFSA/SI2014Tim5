package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class PromjenaLozinkeWindow {

	private JFrame frmPromjenaLozinke;
	private JPasswordField StaraLozinkaTB;
	private JPasswordField NovaLozinkaTB;
	private JPasswordField PotvrdiNovuLozinkuTB;

	/**
	 * Launch the application.
	 */
	private static Korisnik korisnik;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaLozinkeWindow window = new PromjenaLozinkeWindow(korisnik);
					window.frmPromjenaLozinke.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PromjenaLozinkeWindow(Korisnik k) {
		korisnik = k;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaLozinke = new JFrame();
		frmPromjenaLozinke.setTitle("Promjena lozinke");
		frmPromjenaLozinke.setBounds(100, 100, 450, 182);
		frmPromjenaLozinke.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaLozinke.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(105dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStaraLozinka = new JLabel("Stara lozinka:");
		frmPromjenaLozinke.getContentPane().add(lblStaraLozinka, "4, 4, right, default");
		
		StaraLozinkaTB = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(StaraLozinkaTB, "6, 4, fill, default");
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		frmPromjenaLozinke.getContentPane().add(lblNovaLozinka, "4, 6, right, default");
		
		NovaLozinkaTB = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(NovaLozinkaTB, "6, 6, fill, default");
		
		JLabel lblPotvrdiNovuLozinku = new JLabel("Potvrdi novu lozinku:");
		frmPromjenaLozinke.getContentPane().add(lblPotvrdiNovuLozinku, "4, 8, right, default");
		
		PotvrdiNovuLozinkuTB = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(PotvrdiNovuLozinkuTB, "6, 8, fill, default");
		
		JButton btnPromijeni = new JButton("Promijeni");
		btnPromijeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			char[] pass1, pass2, pass3;
			pass1 = StaraLozinkaTB.getPassword();
			pass2 = NovaLozinkaTB.getPassword();
			pass3 = PotvrdiNovuLozinkuTB.getPassword();
			
			String s1, s2, s3;
			s1 = new String(pass1);
			s2 = new String(pass2);
			s3 = new String(pass3);

			
			if (!s1.equals(korisnik.getLozinka()))
				JOptionPane.showMessageDialog(null,"Stara lozinka nije tacna !","Error",JOptionPane.WARNING_MESSAGE);		
			else if (s2.length()<8)
			{
				JOptionPane.showMessageDialog(null,"Lozinka mora imati najmanje 8 znakova !","Error",JOptionPane.WARNING_MESSAGE);
			}
			else if (!s2.equals(s3))
				JOptionPane.showMessageDialog(null,"Lozinka i potvrda lozinke se razlikuju !","Error",JOptionPane.WARNING_MESSAGE);
			else
			{
				Session session = HibernateUtil.getSessionFactory().openSession();
				korisnik.setLozinka(s2);
				korisnik.urediKorisnika(session);
				session.close();
				JOptionPane.showMessageDialog(null,"Uspjesno ste izmijenili lozinku !","Message",JOptionPane.INFORMATION_MESSAGE);
				StaraLozinkaTB.setText("");
				NovaLozinkaTB.setText("");
				PotvrdiNovuLozinkuTB.setText("");
				frmPromjenaLozinke.setVisible(false);
				
			}
			}
		});
		frmPromjenaLozinke.getContentPane().add(btnPromijeni, "6, 10");
	}

}
