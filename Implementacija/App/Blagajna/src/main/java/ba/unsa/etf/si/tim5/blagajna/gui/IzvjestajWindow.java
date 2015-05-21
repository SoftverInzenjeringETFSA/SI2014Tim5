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

import net.sf.jasperreports.components.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports; 
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.exception.DRException;

import javax.swing.*;

import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
		/*private int indeks;
		private String student;
		private double Troskovi;
		private double dug;
		private MozePolagati mozePolagati; */
		TabelaIzvjestaj i1  = new TabelaIzvjestaj(16049, "Sabina Grošić", 1098.5, 200, MozePolagati.DA); 
		TabelaIzvjestaj i2  = new TabelaIzvjestaj(16161, "Arnela Duzan", 200, 200, MozePolagati.DA);
		TabelaIzvjestaj i3  = new TabelaIzvjestaj(16028, "Mesud Klisura", 1098.5, 200, MozePolagati.DA); 
		TabelaIzvjestaj i4  = new TabelaIzvjestaj(16049, "Faris Dzafic", 1098.5, 200, MozePolagati.DA); 
		ArrayList<TabelaIzvjestaj> r = new ArrayList<TabelaIzvjestaj>(); 
		r.add(i1); 
		r.add(i2); 
		r.add(i3); 
		r.add(i4); 

		try {
			GenerisiIzvjestaj(r);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IzvjestajWindow(Korisnik k) {
		korisnik = k;
		initialize();
	}
	
		
	public void GenerisiIzvjestaj(ArrayList<TabelaIzvjestaj> redovi) throws FileNotFoundException, DRException
	{
		//dynamic report
		JasperReportBuilder report = DynamicReports.report(); 
		
		//add title
		TextFieldBuilder<String> title1 = DynamicReports.cmp.text("International Techincal University"); 
		report.title(title1); 
		TextFieldBuilder<String> title2 = DynamicReports.cmp.text("Zmaja od Bosne bb, Kampus Univerziteta u Sarajevu, 71 000 Sarajevo"); 
		report.title(title2); 
		TextFieldBuilder<String> title3 = DynamicReports.cmp.text("Tel: ++387 33 250 700"); 
		report.title(title3);
		
		Date d = new Date(); 
		String s = d.toString(); 
		
		TextFieldBuilder<String> title4 = DynamicReports.cmp.text("Datum: " + s); 
		report.title(title4); 
		
		
		/*private int indeks;
		private String student;
		private double Troskovi;
		private double dug;
		private MozePolagati mozePolagati; */
		
		//add table
		//add columns
		TextColumnBuilder<Integer> indeksKolona = Columns.column("Indeks", "indeks", DynamicReports.type.integerType());
		TextColumnBuilder<String> studentKolona = Columns.column("Ime i prezime", "student", DynamicReports.type.stringType());
		TextColumnBuilder<Double> troskoviKolona = Columns.column("Vrijednost", "troskovi", DynamicReports.type.doubleType());
		TextColumnBuilder<Double> dugKolona = Columns.column("Neplaćeni dug", "dug", DynamicReports.type.doubleType());
		TextColumnBuilder<String> polazeKolona = Columns.column("Može polagati ispit", "mozePolagati", DynamicReports.type.stringType());

		report.columns(indeksKolona, studentKolona, troskoviKolona, dugKolona, polazeKolona); 
		report.setDataSource(redovi); 
		
		report.show(); 
		//report.toPdf(new FileOutputStream(new File("c:/report.pdf"))); //promijeniti lokaciju
		
		
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
					try {
						GenerisiIzvjestaj(redovi);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
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
