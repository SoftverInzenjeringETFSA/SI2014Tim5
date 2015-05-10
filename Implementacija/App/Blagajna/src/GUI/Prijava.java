package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;

public class Prijava {

	private JFrame frmPrijava;
	private JTextField textUser;
	private JPasswordField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava window = new Prijava();
					window.frmPrijava.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prijava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijava = new JFrame();
		frmPrijava.setTitle("Prijava");
		frmPrijava.setBounds(100, 100, 342, 201);
		frmPrijava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijava.getContentPane().setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setBounds(40, 37, 70, 14);
		frmPrijava.getContentPane().add(lblKorisnikoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setBounds(71, 63, 39, 14);
		frmPrijava.getContentPane().add(lblLozinka);
		
		textUser = new JTextField();
		textUser.setBounds(120, 34, 151, 20);
		frmPrijava.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setBounds(120, 60, 151, 20);
		frmPrijava.getContentPane().add(textPass);
		
		JLabel lblZaboraviliSteLozinku = new JLabel("Zaboravili ste lozinku ?");
		lblZaboraviliSteLozinku.setForeground(Color.BLUE);
		lblZaboraviliSteLozinku.setBounds(164, 91, 107, 14);
		frmPrijava.getContentPane().add(lblZaboraviliSteLozinku);
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.setBounds(40, 125, 89, 23);
		frmPrijava.getContentPane().add(btnPrijaviSe);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.setBounds(182, 125, 89, 23);
		frmPrijava.getContentPane().add(btnIzai);
	}
}
