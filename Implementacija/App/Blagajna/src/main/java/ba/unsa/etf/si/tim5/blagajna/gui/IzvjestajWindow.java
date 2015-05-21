package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTextPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
//----------------------
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Mjesec;
import ba.unsa.etf.si.tim5.blagajna.dodaci.MozePolagati;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TabelaIzvjestaj;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipIzvjestaja;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Izvjestaj;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class IzvjestajWindow {

	JFrame frmIzvjetaj;
	static Korisnik korisnik;
	private TipDuga tipDuga;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzvjestajWindow window = new IzvjestajWindow();
					window.frmIzvjetaj.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzvjestajWindow() {
		initialize();
	}

	public IzvjestajWindow(Korisnik k) {
		korisnik = k;
		initialize();
	}

	// ----------------------
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaj = new JFrame();
		frmIzvjetaj.setTitle("Izvje\u0161taj");
		frmIzvjetaj.setBounds(100, 100, 557, 444);
		frmIzvjetaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaj.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] { ColumnSpec.decode("29px"),
						ColumnSpec.decode("81px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("102px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("37px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("103px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("37px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("32px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("55px"), }, new RowSpec[] {
						RowSpec.decode("30px"), RowSpec.decode("20px"),
						FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("23px"),
						FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("14px"),
						FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("239px"),
						RowSpec.decode("21px"), RowSpec.decode("23px"), }));

		JLabel lblTipIzvjetaja = new JLabel("Tip izvje\u0161taja:");
		frmIzvjetaj.getContentPane()
				.add(lblTipIzvjetaja, "2, 2, right, center");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipIzvjestaja.values()));
		frmIzvjetaj.getContentPane().add(comboBox, "4, 2, fill, center");

		JLabel lblMjesec = new JLabel("Mjesec:");
		frmIzvjetaj.getContentPane().add(lblMjesec, "6, 2, right, center");

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Mjesec.values()));
		frmIzvjetaj.getContentPane().add(comboBox_1, "8, 2, fill, center");

		JLabel lblPrikazIzvjetaja = new JLabel("Prikaz izvje\u0161taja:");
		frmIzvjetaj.getContentPane().add(lblPrikazIzvjetaja,
				"2, 6, 3, 1, center, center");

		final JTextPane textPane = new JTextPane();
		frmIzvjetaj.getContentPane().add(textPane, "2, 8, 13, 1, fill, fill");

		JButton btnIzai = new JButton("Iza\u0111i");
		frmIzvjetaj.getContentPane()
				.add(btnIzai, "12, 10, 3, 1, right, center");

		JButton btnGenerisi = new JButton("Generi\u0161i izvje\u0161taj");
		btnGenerisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((TipIzvjestaja)comboBox.getSelectedItem() == TipIzvjestaja.TroskoviStudija) tipDuga = TipDuga.dugZaSkolarinu;
			else tipDuga = TipDuga.dugZaLiteraturu;
				ArrayList<Dug> dugovi = Dao.getInstance().dajSveDugovePoTipu(tipDuga);
				ArrayList<TabelaIzvjestaj> redovi = new ArrayList<TabelaIzvjestaj>();
				for(int i = 0; i<dugovi.size(); i++) {
					Student s = dugovi.get(i).dajStudenta();
					
					double ukupanDug = dugovi.get(i).getVrijednost();
					double dug = dugovi.get(i).dajVrijednostDuga();
					
					TabelaIzvjestaj ti = new TabelaIzvjestaj(s.getIndeks(),
							s.getIme() + " " + s.getPrezime(), ukupanDug, dug, dug == 0 ? MozePolagati.DA : MozePolagati.NE);
					
					redovi.add(ti);
					
					//poziv funkcije za generisanje
					
				}
			}
		});

		frmIzvjetaj.getContentPane().add(btnGenerisi,
				"2, 4, 13, 1, fill, center");

		JButton btnNewButton = new JButton("Printaj");
		frmIzvjetaj.getContentPane().add(btnNewButton, "2, 10, center, center");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");

			}

		});
		class btnPrintAction implements ActionListener, Printable {

			public int print(Graphics gx, PageFormat pf, int page)
					throws PrinterException {
				if (page > 0) {
					return NO_SUCH_PAGE;
				}
				Graphics2D g = (Graphics2D) gx;
				g.translate(pf.getImageableX(), pf.getImageableY());
				g.drawString("Hello world", 100, 100);
				return PAGE_EXISTS;
			}

			public void actionPerformed(ActionEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(this);
				if (job.printDialog() == true) {
					try {
						job.print();
					} catch (PrinterException ex) {
					}
				}
			}
		}

		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Iza\u0111i")) {

					System.exit(0);
				}
			}
		});

	}
}
