package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

import java.awt.Choice;
import java.awt.Button;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class UnosWindow {

	private JFrame frmUnosStudenta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel lblGodinaKojuUpisje;
	private JLabel lblPopust;
	private JTextField textField_13;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;
	private JButton btnUnesi;
	private JLabel lblKm;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblEmail;
	private JTextField textField_12;
	private JLabel lblUkupniTrokovi;
	private JLabel lblcijena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosWindow window = new UnosWindow();
					window.frmUnosStudenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosWindow() {
		initialize();
	}	
	
	private ArrayList<Student> studenti;
	private Student student;
	public UnosWindow(ArrayList<Student> studenti) {
		initialize();
		this.studenti = studenti;
	}
	public UnosWindow(Student student) {
		initialize();
		this.student = student;		
	}	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosStudenta = new JFrame();
		frmUnosStudenta.setTitle("Unos studenta");
		frmUnosStudenta.setResizable(false);
		frmUnosStudenta.setBounds(100, 100, 779, 407);
		frmUnosStudenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmUnosStudenta.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("326px"),
					ColumnSpec.decode("337px"),
					ColumnSpec.decode("91px"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("185px"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("136px"),
					FormFactory.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("23px"),}));
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Li�ni podaci"));
			frmUnosStudenta.getContentPane().add(panel, "2, 2, 3, 1, fill, fill");
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(116dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(126dlu;default):grow"),},
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
					FormFactory.DEFAULT_ROWSPEC,}));
			
				
				JLabel lblNewLabel = new JLabel("Ime:");
				
				panel.add(lblNewLabel, "2, 2");
				
				textField = new JTextField();
				panel.add(textField, "4, 2");
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Mjesto ro\u0111enja:");
				panel.add(lblNewLabel_2, "8, 2");
				
				textField_1 = new JTextField();
				panel.add(textField_1, "10, 2");
				textField_1.setColumns(10);
				
				JLabel lblPrezime = new JLabel("Prezime:");
				panel.add(lblPrezime, "2, 4");
				
				textField_2 = new JTextField();
				panel.add(textField_2, "4, 4");
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("Op\u0107ina ro\u0111enja:");
				panel.add(lblNewLabel_3, "8, 4");
				
				textField_6 = new JTextField();
				panel.add(textField_6, "10, 4");
				textField_6.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Ime roditelja:");
				panel.add(lblNewLabel_1, "2, 6");
				
				textField_3 = new JTextField();
				panel.add(textField_3, "4, 6");
				textField_3.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Dr\u017Eava ro\u0111enja:");
				panel.add(lblNewLabel_4, "8, 6");
				
				textField_7 = new JTextField();
				panel.add(textField_7, "10, 6");
				textField_7.setColumns(10);
				
				JLabel lblBrojTelefona = new JLabel("Broj telefona:");
				panel.add(lblBrojTelefona, "2, 8");
				
				textField_4 = new JTextField();
				panel.add(textField_4, "4, 8");
				textField_4.setColumns(10);
				
				JLabel lblAdresaPrebivalita = new JLabel("Adresa prebivali\u0161ta:");
				panel.add(lblAdresaPrebivalita, "8, 8");
				
				textField_8 = new JTextField();
				panel.add(textField_8, "10, 8");
				textField_8.setColumns(10);
				
				JLabel lblJmbg = new JLabel("JMBG:");
				panel.add(lblJmbg, "2, 10");
				
				textField_5 = new JTextField();
				panel.add(textField_5, "4, 10");
				textField_5.setColumns(10);
				
				JLabel lblOpinaPrebivalita = new JLabel("Op\u0107ina prebivali\u0161ta:");
				panel.add(lblOpinaPrebivalita, "8, 10");
				
				textField_9 = new JTextField();
				panel.add(textField_9, "10, 10");
				textField_9.setColumns(10);
				
				lblEmail = new JLabel("E-Mail:");
				panel.add(lblEmail, "8, 12, right, default");
				
				textField_12 = new JTextField();
				textField_12.setColumns(10);
				panel.add(textField_12, "10, 12, fill, default");
				
				panel_1 = new JPanel();
				panel_1.setBorder(BorderFactory.createTitledBorder("Podaci o studiju"));
				frmUnosStudenta.getContentPane().add(panel_1, "2, 4, 3, 1, fill, fill");
				panel_1.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(104dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default:grow"),
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
						FormFactory.DEFAULT_ROWSPEC,}));
				
				lblNewLabel_5 = new JLabel("Broj indeksa:");
				panel_1.add(lblNewLabel_5, "2, 2, right, default");
				
				textField_10 = new JTextField();
				panel_1.add(textField_10, "4, 2, left, default");
				textField_10.setColumns(10);
				
				lblNewLabel_6 = new JLabel("Tro\u0161kovi strudija:");
				panel_1.add(lblNewLabel_6, "8, 2, right, default");
				
				textField_11 = new JTextField();
				panel_1.add(textField_11, "10, 2, 3, 1, fill, default");
				textField_11.setColumns(10);
				
				lblKm = new JLabel("KM");
				panel_1.add(lblKm, "14, 2");
				
				lblGodinaKojuUpisje = new JLabel("Godina koju upisje:");
				panel_1.add(lblGodinaKojuUpisje, "2, 4, right, default");
				
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(GodinaStudija.values()));
				panel_1.add(comboBox, "4, 4, fill, default");
				
				lblPopust = new JLabel("Popust:");
				panel_1.add(lblPopust, "8, 4, right, default");
				
				textField_13 = new JTextField();
				panel_1.add(textField_13, "10, 4, 3, 1, fill, default");
				textField_13.setColumns(10);
				
				lblNewLabel_7 = new JLabel("%");
				panel_1.add(lblNewLabel_7, "14, 4");
				
				chckbxNewCheckBox = new JCheckBox("Prvi put se unosi u sistem:");
				panel_1.add(chckbxNewCheckBox, "4, 6");
				
				lblUkupniTrokovi = new JLabel("Ukupni tro\u0161kovi:");
				panel_1.add(lblUkupniTrokovi, "8, 6, right, default");
				
				lblcijena = new JLabel("{cijena KM}");
				panel_1.add(lblcijena, "10, 6, left, default");
				
				btnUnesi = new JButton("Unesi");
				frmUnosStudenta.getContentPane().add(btnUnesi, "2, 6, fill, top");
				
				btnNewButton_1 = new JButton("Iza\u0111i");
				frmUnosStudenta.getContentPane().add(btnNewButton_1, "4, 6, right, top");
	}

}
