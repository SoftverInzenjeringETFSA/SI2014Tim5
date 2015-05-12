package GUI;

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

import util.HibernateUtil;
import Dodaci.GodinaStudija;
import Entiteti.Literatura;

public class DugWindow {
		
	private JFrame frmDugovanjaUplate;
	private JTable table;
	private JLabel lblStudent;
	private JLabel lblimeIPrezime;
	private JLabel lblStudijskaGodina;
	private JComboBox comboBox;
	private JLabel lblUkupanDug;
	private JLabel lbldug;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DugWindow window = new DugWindow();
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
	public DugWindow() {
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
		frmDugovanjaUplate.getContentPane().add(lblimeIPrezime, "5, 4");
		
		lblStudijskaGodina = new JLabel("Studijska godina:");
		frmDugovanjaUplate.getContentPane().add(lblStudijskaGodina, "7, 4, right, default");
		
		comboBox = new JComboBox();
		frmDugovanjaUplate.getContentPane().add(comboBox, "9, 4, fill, default");
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
		JScrollPane scrollPane = new JScrollPane(table);
		frmDugovanjaUplate.getContentPane().add(scrollPane, "3, 8, 7, 1, fill, fill");
		
		lblUkupanDug = new JLabel("Ukupan dug:");
		frmDugovanjaUplate.getContentPane().add(lblUkupanDug, "7, 12");
		
		lbldug = new JLabel("{dug}");
		frmDugovanjaUplate.getContentPane().add(lbldug, "9, 12");
		
		btnNewButton = new JButton("Uplati");
		frmDugovanjaUplate.getContentPane().add(btnNewButton, "3, 14, 7, 1");
		
		btnNewButton_1 = new JButton("Printaj potvrdu");
		frmDugovanjaUplate.getContentPane().add(btnNewButton_1, "3, 18, 7, 1");
		
		
		//frame.getContentPane().add(table, "2, 4, fill, fill");
	}

}
