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
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
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
import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TabelaIzvjestaj;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipIzvjestaja;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import org.apache.log4j.Logger;
public class IzvjestajWindow {

	final static Logger logger = Logger.getLogger(SlanjeMaila.class);
	JFrame frmIzvjetaj;
	JComboBox comboBox;
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
					logger.error("Greška pri otvaranju forme za izvještaj! " + e.getMessage() , e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzvjestajWindow() {
		initialize();
		/*
		 * private int indeks; private String student; private double Troskovi;
		 * private double dug; private MozePolagati mozePolagati;
		 */
		// TabelaIzvjestaj i1 = new TabelaIzvjestaj(16049, "Sabina Grošić",
		// 1098.5, 200, MozePolagati.DA);
		// TabelaIzvjestaj i2 = new TabelaIzvjestaj(16161, "Arnela Duzan", 200,
		// 200, MozePolagati.DA);
		// TabelaIzvjestaj i3 = new TabelaIzvjestaj(16028, "Mesud Klisura",
		// 1098.5, 200, MozePolagati.DA);
		// TabelaIzvjestaj i4 = new TabelaIzvjestaj(16049, "Faris Dzafic",
		// 1098.5, 200, MozePolagati.DA);
		// ArrayList<TabelaIzvjestaj> r = new ArrayList<TabelaIzvjestaj>();
		// r.add(i1);
		// r.add(i2);
		// r.add(i3);
		// r.add(i4);
		//
		// try {
		// GenerisiIzvjestaj(r);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (DRException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public IzvjestajWindow(Korisnik k) {
		korisnik = k;
		initialize();
	}

	public void GenerisiIzvjestaj(ArrayList<TabelaIzvjestaj> redovi)
			throws FileNotFoundException, DRException {
		// dynamic report
		JasperReportBuilder report = DynamicReports.report();

		// styles
		StyleBuilder boldStyle = DynamicReports.stl.style().bold();
		StyleBuilder totalStyle = DynamicReports.stl.style().bold()
				.setBackgroundColor(Color.YELLOW)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder boldCentered = DynamicReports.stl.style(boldStyle)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder columnHeaderStyle = DynamicReports.stl.style(boldCentered)
				.setBorder(DynamicReports.stl.pen1Point())
				.setBackgroundColor(Color.PINK);

		// add title
		TextFieldBuilder<String> title1 = DynamicReports.cmp
				.text("{ Naziv fakulteta }").setStyle(boldStyle)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		report.title(title1);
		TextFieldBuilder<String> title2 = DynamicReports.cmp
				.text("{ Adresa fakulteta }").setStyle(boldStyle)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		report.title(title2);
		TextFieldBuilder<String> title3 = DynamicReports.cmp
				.text("{ Kontakt info }\n\n\n").setStyle(boldStyle)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		report.title(title3);

		if ((TipIzvjestaja) comboBox.getSelectedItem() == TipIzvjestaja.TroskoviStudija) {
			TextFieldBuilder<String> naziv = DynamicReports.cmp
					.text("Izvještaj o troškovima studija\n\n")
					.setStyle(boldStyle)
					.setHorizontalAlignment(HorizontalAlignment.CENTER);
			report.title(naziv);
		} else {
			TextFieldBuilder<String> naziv = DynamicReports.cmp
					.text("Izvještaj o troškovima za literaturu\n\n")
					.setStyle(boldStyle)
					.setHorizontalAlignment(HorizontalAlignment.CENTER);
			report.title(naziv);

		}
		TextFieldBuilder<String> potpis = DynamicReports.cmp.text(
				"Potpis ovlaštenog:  _________________________\n")
				.setHorizontalAlignment(HorizontalAlignment.LEFT);
		report.title(potpis);

		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("dd.MM.yyyy   HH:mm");
		String s = d.format(date);

		TextFieldBuilder<String> title4 = DynamicReports.cmp.text(
				"Datum i vrijeme: " + s + "\n\n\n").setHorizontalAlignment(
				HorizontalAlignment.LEFT);
		report.title(title4);

		/*
		 * private int indeks; private String student; private double Troskovi;
		 * private double dug; private MozePolagati mozePolagati;
		 */

		// add table
		// add columns
		TextColumnBuilder<String> indeksKolona = Columns.column("Indeks",
				"indeks", DynamicReports.type.stringType());
		TextColumnBuilder<String> studentKolona = Columns.column(
				"Ime i prezime", "student", DynamicReports.type.stringType());
		TextColumnBuilder<Double> troskoviKolona = Columns
				.column("Vrijednost (KM)", "troskovi",
						DynamicReports.type.doubleType());
		TextColumnBuilder<Double> dugKolona = Columns.column(
				"Neplaćeni dug (KM)", "dug", DynamicReports.type.doubleType());
		TextColumnBuilder<String> polazeKolona = Columns.column(
				"Može polagati ispit", "mozePolagati",
				DynamicReports.type.stringType());

		// numeration of rows
		TextColumnBuilder<Integer> rowNumColumn = Columns
				.reportRowNumberColumn("R.Broj").setFixedColumns(2)
				.setHorizontalAlignment(HorizontalAlignment.CENTER);

		report.columns(rowNumColumn, indeksKolona, studentKolona,
				troskoviKolona, dugKolona, polazeKolona);

		// add title column style
		report.setColumnTitleStyle(columnHeaderStyle);

		// suma
		report.subtotalsAtSummary(DynamicReports.sbt.sum(troskoviKolona)
				.setStyle(totalStyle));
		report.subtotalsAtSummary(DynamicReports.sbt.sum(dugKolona).setStyle(
				totalStyle));

		// add data source
		report.setDataSource(redovi);

		// footer
		report.pageFooter(DynamicReports.cmp.pageXofY().setStyle(boldCentered));

		// highlight rows
		report.highlightDetailEvenRows();

		ReportStyleBuilder textStyle = DynamicReports.stl.style()
				.setHorizontalAlignment(HorizontalAlignment.CENTER);
		report.setTextStyle(textStyle);

		report.show();
		// report.toPdf(new FileOutputStream(new File("c:/report.pdf")));
		// //promijeniti lokaciju

	}

	// ----------------------
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaj = new JFrame();
		frmIzvjetaj.setTitle("Izvje\u0161taj");
		frmIzvjetaj.setBounds(100, 100, 311, 195);
		frmIzvjetaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaj.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("29px"),
				ColumnSpec.decode("81px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("102px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("37px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("37px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("21px"),
				RowSpec.decode("23px"),}));

		JLabel lblTipIzvjetaja = new JLabel("Tip izvje\u0161taja:");
		frmIzvjetaj.getContentPane()
				.add(lblTipIzvjetaja, "2, 4, right, center");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipIzvjestaja.values()));
		frmIzvjetaj.getContentPane().add(comboBox, "4, 4, 3, 1, fill, center");

		JButton btnGenerisi = new JButton("Generi\u0161i izvje\u0161taj");
		btnGenerisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//izbor selektovanog tipa izcjestaja
				if ((TipIzvjestaja) comboBox.getSelectedItem() == TipIzvjestaja.TroskoviStudija)
					tipDuga = TipDuga.dugZaSkolarinu;
				else
					tipDuga = TipDuga.dugZaLiteraturu;
				
				//dobavaljanje svih
				ArrayList<Dug> dugovi = Dao.getInstance().dajSveDugove();				

				ArrayList<TabelaIzvjestaj> redovi = new ArrayList<TabelaIzvjestaj>();
				for (int i = 0; i < dugovi.size(); i++) {
					if(dugovi.get(i).getTipDuga() != tipDuga) continue;
					Student s = dugovi.get(i).dajStudenta();
					double ukupanDug = dugovi.get(i).getVrijednost();
					double dug = dugovi.get(i).dajVrijednostDuga();

					TabelaIzvjestaj ti = new TabelaIzvjestaj(s.getIndeks(), s
							.getIme() + " " + s.getPrezime(), ukupanDug, dug,
							dug == 0 ? MozePolagati.DA : MozePolagati.NE);

					redovi.add(ti);
				}
				// poziv funkcije za generisanje
				try {
					GenerisiIzvjestaj(redovi);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					logger.error("Greška pri generisanju izvještaja! " + e1.getMessage() , e1);
				} catch (DRException e1) {
					logger.error("Greška pri generisanju izvještaja! " + e1.getMessage() , e1);
					e1.printStackTrace();
				}

			}
		});

		frmIzvjetaj.getContentPane().add(btnGenerisi,
				"2, 6, 5, 1, fill, center");
				
						JButton btnIzai = new JButton("Iza\u0111i");
						frmIzvjetaj.getContentPane().add(btnIzai, "4, 9, 3, 1, right, center");

		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIzvjetaj.setVisible(false); //you can't see me!
				frmIzvjetaj.dispose();
			}
		});

	}
}
