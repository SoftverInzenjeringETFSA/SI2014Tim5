package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class KupiLiteraturuWindow {

	private JFrame frmKupovinaLiterature;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KupiLiteraturuWindow window = new KupiLiteraturuWindow();
					window.frmKupovinaLiterature.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KupiLiteraturuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKupovinaLiterature = new JFrame();
		frmKupovinaLiterature.setTitle("Kupovina literature");
		frmKupovinaLiterature.setBounds(100, 100, 450, 353);
		frmKupovinaLiterature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKupovinaLiterature.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(107dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStudent = new JLabel("Student:");
		frmKupovinaLiterature.getContentPane().add(lblStudent, "4, 4");
		
		JLabel lblimeIPrezime = new JLabel("{ime i prezime}");
		frmKupovinaLiterature.getContentPane().add(lblimeIPrezime, "6, 4");
		
		JLabel lblIsbin = new JLabel("Odaberi:");
		frmKupovinaLiterature.getContentPane().add(lblIsbin, "4, 8, right, default");
		
		JComboBox comboBox = new JComboBox();
		frmKupovinaLiterature.getContentPane().add(comboBox, "6, 8, fill, default");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Detalji"));
		frmKupovinaLiterature.getContentPane().add(panel, "4, 10, 3, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblIsbn = new JLabel("ISBN:");
		panel.add(lblIsbn, "2, 4");
		
		JLabel lblisbn = new JLabel("{isbn}");
		panel.add(lblisbn, "4, 4");
		
		JLabel lblNaziv = new JLabel("Naziv:");
		panel.add(lblNaziv, "2, 6");
		
		JLabel lblnaziv = new JLabel("{naziv}");
		panel.add(lblnaziv, "4, 6");
		
		JLabel lblAutor = new JLabel("Autor:");
		panel.add(lblAutor, "2, 8");
		
		JLabel lblautor = new JLabel("{autor}");
		panel.add(lblautor, "4, 8");
		
		JLabel lblCijena = new JLabel("Cijena:");
		panel.add(lblCijena, "2, 10");
		
		JLabel lblcijena = new JLabel("{cijena}");
		panel.add(lblcijena, "4, 10");
		
		JLabel label = new JLabel("Koli\u010Dina:");
		panel.add(label, "2, 12");
		
		JLabel label_1 = new JLabel("{kolicina}");
		panel.add(label_1, "4, 12");
		
		JButton btnKupi = new JButton("Kupi");
		frmKupovinaLiterature.getContentPane().add(btnKupi, "6, 12");
	}

}
