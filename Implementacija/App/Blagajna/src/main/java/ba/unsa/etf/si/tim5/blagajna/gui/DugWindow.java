package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.util.*;
import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DugWindow {
		
	private JFrame frmDugovanjaUplate;
	private JTable table;
	private JLabel lblStudent;
	private JLabel lblimeIPrezime;
	private JLabel lblStudijskaGodina;
	private JComboBox StudijskaGodinaCB;
	private JLabel lblUkupanDug;
	private JLabel lblDug;
	private JButton btnUplati;
	private JButton btnPrintaj;
	private static Student student;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DugWindow window = new DugWindow(student);
					window.frmDugovanjaUplate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DugWindow(Student s) {
		student = s;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDugovanjaUplate = new JFrame();
		frmDugovanjaUplate.setTitle("Dugovanja - Uplate");
		frmDugovanjaUplate.setBounds(100, 100, 548, 438);
		frmDugovanjaUplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDugovanjaUplate.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblStudent = new JLabel("Student: ");
		frmDugovanjaUplate.getContentPane().add(lblStudent, "3, 4");
		
		lblimeIPrezime = new JLabel("{ime i prezime}");
		lblimeIPrezime.setText(student.getIme() + " "+ student.getPrezime());
		frmDugovanjaUplate.getContentPane().add(lblimeIPrezime, "5, 4");
		
		lblStudijskaGodina = new JLabel("Studijska godina:");
		frmDugovanjaUplate.getContentPane().add(lblStudijskaGodina, "7, 4, right, default");
		
		StudijskaGodinaCB = new JComboBox();
		StudijskaGodinaCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studijskaGodina =StudijskaGodinaCB.getSelectedItem().toString();
			}
		});
		frmDugovanjaUplate.getContentPane().add(StudijskaGodinaCB, "9, 4, fill, default");
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", "", null, null},
			},
			new String[] {
				"Id", "Dug", "Datum zadu\u017Eenja", "Datum razdu\u017Eenja", "Rok za uplatu", "Tip duga"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(7);
		table.getColumnModel().getColumn(2).setMinWidth(18);
		table.getColumnModel().getColumn(3).setMinWidth(18);
		JScrollPane TabelaDugova = new JScrollPane(table);
		frmDugovanjaUplate.getContentPane().add(TabelaDugova, "3, 8, 7, 1, fill, fill");
		
		lblUkupanDug = new JLabel("Ukupan dug:");
		frmDugovanjaUplate.getContentPane().add(lblUkupanDug, "7, 12");
		
		lblDug = new JLabel("{dug}");
		frmDugovanjaUplate.getContentPane().add(lblDug, "9, 12");
		
		btnUplati = new JButton("Uplati");
		frmDugovanjaUplate.getContentPane().add(btnUplati, "3, 14, 7, 1");
		
		btnPrintaj = new JButton("Printaj potvrdu");
		frmDugovanjaUplate.getContentPane().add(btnPrintaj, "3, 18, 7, 1, default, top");
		
		
		//frame.getContentPane().add(table, "2, 4, fill, fill");
	}

}
