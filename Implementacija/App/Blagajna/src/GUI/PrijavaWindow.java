package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class PrijavaWindow {

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
					PrijavaWindow window = new PrijavaWindow();
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
	public PrijavaWindow() {
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
		frmPrijava.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("21px"),
				ColumnSpec.decode("89px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("89px"),},
			new RowSpec[] {
				RowSpec.decode("34px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("20px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		frmPrijava.getContentPane().add(lblKorisnikoIme, "2, 2, right, center");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		frmPrijava.getContentPane().add(lblLozinka, "2, 4, right, center");
		
		textUser = new JTextField();
		frmPrijava.getContentPane().add(textUser, "4, 2, 3, 1, fill, top");
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		frmPrijava.getContentPane().add(textPass, "4, 4, 3, 1, fill, top");
		
		JLabel lblZaboraviliSteLozinku = new JLabel("Zaboravili ste lozinku ?");
		lblZaboraviliSteLozinku.setForeground(Color.BLUE);
		frmPrijava.getContentPane().add(lblZaboraviliSteLozinku, "4, 6, 3, 1, fill, top");
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		frmPrijava.getContentPane().add(btnPrijaviSe, "2, 8, 3, 1, right, top");
		
		JButton btnIzai = new JButton("Iza\u0111i");
		frmPrijava.getContentPane().add(btnIzai, "6, 8, fill, top");
	}
}
