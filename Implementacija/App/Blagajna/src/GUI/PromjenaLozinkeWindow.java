package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PromjenaLozinkeWindow {

	private JFrame frmPromjenaLozinke;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaLozinkeWindow window = new PromjenaLozinkeWindow();
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
	public PromjenaLozinkeWindow() {
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
		
		passwordField = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(passwordField, "6, 4, fill, default");
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		frmPromjenaLozinke.getContentPane().add(lblNovaLozinka, "4, 6, right, default");
		
		passwordField_1 = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(passwordField_1, "6, 6, fill, default");
		
		JLabel lblPotvrdiNovuLozinku = new JLabel("Potvrdi novu lozinku:");
		frmPromjenaLozinke.getContentPane().add(lblPotvrdiNovuLozinku, "4, 8, right, default");
		
		passwordField_2 = new JPasswordField();
		frmPromjenaLozinke.getContentPane().add(passwordField_2, "6, 8, fill, default");
		
		JButton btnPromijeni = new JButton("Promijeni");
		frmPromjenaLozinke.getContentPane().add(btnPromijeni, "6, 10");
	}

}
