package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import Entiteti.Student;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Insets;

public class KorisniciWindow {

	private JFrame frmKorisnici;	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisniciWindow window = new KorisniciWindow();
					window.frmKorisnici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KorisniciWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKorisnici = new JFrame();
		frmKorisnici.setTitle("Korisnici");
		frmKorisnici.setBounds(100, 100, 593, 425);
		frmKorisnici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("71px:grow"),
				ColumnSpec.decode("95px:grow"),
				ColumnSpec.decode("129px:grow"),
				ColumnSpec.decode("128px:grow"),
				ColumnSpec.decode("131px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("33px"),
				RowSpec.decode("fill:269px:grow"),
				RowSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,});
		frmKorisnici.getContentPane().setLayout(formLayout);
				
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		frmKorisnici.getContentPane().add(scrollPane, "2, 3, 5, 2");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Fuad Backovi\u0107", "1234", "asd@as.csa", "Administrator"},
				{"2", "Aca Lukas", "15231", "asdf@www.xxx", null},
			},
			new String[] {
				"ID", "Ime i Prezime", "Telefon", "E-Mail", "Tip"
			}
		));
		
		JButton btnDodaj = new JButton("Dodaj");
		frmKorisnici.getContentPane().add(btnDodaj, "3, 5, center, default");
		
		JButton btnUredi = new JButton("Detalji/Uredi");
		frmKorisnici.getContentPane().add(btnUredi, "4, 5, center, default");
		
		JButton btnObrisi = new JButton("Obrisi");
		frmKorisnici.getContentPane().add(btnObrisi, "5, 5, center, default");
		
		

	}

}
