package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Panel;

import javax.swing.JList;

import java.awt.Choice;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;

import java.awt.Color;


import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import java.awt.ScrollPane;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.List;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;


public class MainWindow {

	private JFrame frmBlagajna;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmBlagajna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlagajna = new JFrame();
		frmBlagajna.setTitle("Blagajna\r\n");
		frmBlagajna.setBounds(100, 100, 673, 466);
		frmBlagajna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("75px:grow"),
				ColumnSpec.decode("122px:grow"),
				ColumnSpec.decode("129px:grow"),
				ColumnSpec.decode("128px:grow"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("94px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("33px"),
				RowSpec.decode("fill:269px:grow"),
				RowSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,});
		frmBlagajna.getContentPane().setLayout(formLayout);
		
		JLabel lblDo = new JLabel("Dobar dan, ");
		lblDo.setVerticalAlignment(SwingConstants.TOP);
		lblDo.setHorizontalAlignment(SwingConstants.RIGHT);
		frmBlagajna.getContentPane().add(lblDo, "2, 4");
		
		JLabel lblIme = new JLabel("{Ime}");
		frmBlagajna.getContentPane().add(lblIme, "3, 4");
		
		JLabel label = new JLabel("Pretraga po:");
		frmBlagajna.getContentPane().add(label, "3, 5, center, default");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Indeks", "Naziv", "Dug za skolarinu", "Dug za literaturu"}));
		frmBlagajna.getContentPane().add(comboBox, "4, 5");
		
		textField = new JTextField();
		frmBlagajna.getContentPane().add(textField, "5, 5");
		textField.setColumns(10);
		
		JButton btnPretrai = new JButton("Pretra\u017Ei");
		frmBlagajna.getContentPane().add(btnPretrai, "6, 5");
		
		JScrollPane scrollPane = new JScrollPane();
		frmBlagajna.getContentPane().add(scrollPane, "2, 6, 7, 1");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Ime i Prezime", "Indeks", "Dug za \u0161koralinu", "Dug za literaturu"
			}
		));
		
		JButton btnObrisi = new JButton("Obrisi");
		
		JButton btnUredi = new JButton("Detalji/\r\nUredi");
		
		JButton button = new JButton("Uplate");
		frmBlagajna.getContentPane().add(button, "3, 7");
		
		JButton btnZaduiKnjigu = new JButton("Kupi literaturu");
		frmBlagajna.getContentPane().add(btnZaduiKnjigu, "4, 7, right, default");
		frmBlagajna.getContentPane().add(btnUredi, "5, 7, center, default");
		frmBlagajna.getContentPane().add(btnObrisi, "8, 7, fill, default");
		
		JMenuBar menuBar = new JMenuBar();
		frmBlagajna.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmUplate = new JMenuItem("Promijeni lozinku");
		mnFile.add(mntmUplate);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNapusti = new JMenuItem("Napusti");
		mnFile.add(mntmNapusti);
		
		JMenu mnUredi = new JMenu("Uredi");
		menuBar.add(mnUredi);
		
		JMenuItem mntmUrediUposlenike = new JMenuItem("Uredi korisnike");
		mntmUrediUposlenike.setVisible(false);
		mnUredi.add(mntmUrediUposlenike);
		
		JMenuItem mntmLiteratura = new JMenuItem("Uredi literaturu");
		mnUredi.add(mntmLiteratura);
		
		JMenu mnDodaj = new JMenu("Dodaj");
		menuBar.add(mnDodaj);
		
		JMenuItem mntmDodajStudenta = new JMenuItem("Dodaj studenta");
		mnDodaj.add(mntmDodajStudenta);
		
		JMenuItem mntmDodajKorisnika = new JMenuItem("Dodaj korisnika");
		mnDodaj.add(mntmDodajKorisnika);
		
		JMenuItem mntmDodajLiteraturu = new JMenuItem("Dodaj literaturu");
		mnDodaj.add(mntmDodajLiteraturu);
		
		JMenu mnIzvjetaj = new JMenu("Izvje\u0161taj");
		menuBar.add(mnIzvjetaj);
		DefaultTableModel model = (DefaultTableModel) table.getModel();		
	}
}
