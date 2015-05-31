package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Utility;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class ZaboraviliLozinkuWindow {
	final static Logger logger=Logger.getLogger(ZaboraviliLozinkuWindow.class);
	JFrame frmPromjenaLozinke;
	private JTextField textField;
	ArrayList<Korisnik> sviKorisnici=new ArrayList<Korisnik>();
	Korisnik logovaniKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZaboraviliLozinkuWindow window = new ZaboraviliLozinkuWindow();
					window.frmPromjenaLozinke.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Greška pri otvaranju glavne forme!" + e.getMessage(), e);
				}
			}
		});
	}
	
	public void ucitajSveKorisnike(){
		sviKorisnici= Dao.getInstance().dajSveKorisnike();
	}

	/**
	 * Create the application.
	 */
	public ZaboraviliLozinkuWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaLozinke = new JFrame();
		frmPromjenaLozinke.setTitle("Promjena lozinke");
		frmPromjenaLozinke.setBounds(100, 100, 460, 152);
		frmPromjenaLozinke.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPromjenaLozinke.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblUnesiteVaEmail = new JLabel("Unesite va\u0161 e-mail:");
		frmPromjenaLozinke.getContentPane().add(lblUnesiteVaEmail, "4, 4, right, default");
		
		textField = new JTextField();
		frmPromjenaLozinke.getContentPane().add(textField, "6, 4, 11, 1, fill, default");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Po\u0161alji novu lozinku");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucitajSveKorisnike();
				String email=textField.getText();
				int a=Utility.getInstance().generisiPassword();
				boolean dobarEmail=false;
				
				for(int i=0;i<sviKorisnici.size();i++)
				{
					if(sviKorisnici.get(i).getMail().equals(email))
					{   
						System.out.println("dobar");
						dobarEmail=true;
						String[] m = {email};
						
						textField.setText("");
						Session session = HibernateUtil.getSessionFactory()
								.openSession();
						sviKorisnici.get(i).urediKorisnika(session);
						session.close();
						SlanjeMaila.getInstance().sendFromGMail(m, "Promjena lozinke", "Vaša nova lozinka je: "+ String.valueOf(a));	
						JOptionPane.showMessageDialog(null, "Vaša lozinka je poslana, provjerite inbox vašeg e-mail-a!", "InfoBox: " + "Uspješno slanje maila.", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					
				}
				
				if(dobarEmail==false)
				{
					JOptionPane.showMessageDialog(null, "Email je netačan, pokušajte ponovo!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
					textField.setText("");
					
				}
			}
		});
		frmPromjenaLozinke.getContentPane().add(btnNewButton, "6, 6, 11, 1");
		
		JLabel lblNewLabel = new JLabel("Napomena: Une\u0161eni mail mora biti onaj sa kojim ste prijavljeni na sistem.");
		frmPromjenaLozinke.getContentPane().add(lblNewLabel, "4, 8, 21, 1");
	}

}
