package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.MozePolagati;
import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TabelaIzvjestaj;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipIzvjestaja;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
//----------------------
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
					logger.error(e.getMessage() , e);
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
		
		initialize();
		korisnik = k;
	}

	public void GenerisiIzvjestaj(ArrayList<TabelaIzvjestaj> redovi)
			throws FileNotFoundException, DRException {
		// dynamic report
		if(redovi.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoje studenti koji imaju dug za literaturu!",
							"Obavijest",
							JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		JasperReportBuilder report = DynamicReports.report();		
		// style
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
		report.show(false);
	
	}

	// ----------------------
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaj = new JFrame();
		frmIzvjetaj.setTitle("Izvje\u0161taj");
		frmIzvjetaj.setBounds(100, 100, 311, 195);
		frmIzvjetaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			//@Override
			
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
					double ukupanDug;
					double dug;
					if ((TipIzvjestaja) comboBox.getSelectedItem() == TipIzvjestaja.TroskoviStudija) {
						ukupanDug = s.getTroskoviSkolarine();
						dug = s.dajNeisplaceneDugoveSkolarina();
					} else {
						ukupanDug = s.getTroskoviLiterature();
						dug = s.dajNeisplaceneDugoveLiteratura();
					}

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
					logger.error(e1.getMessage() , e1);
				} catch (DRException e1) {
										
					logger.error(e1.getMessage() , e1);
				}

			}
		});

		frmIzvjetaj.getContentPane().add(btnGenerisi,
				"2, 6, 5, 1, fill, center");
				
						JButton btnIzai = new JButton("Iza\u0111i");
						frmIzvjetaj.getContentPane().add(btnIzai, "4, 9, 3, 1, right, center");

		btnIzai.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				frmIzvjetaj.setVisible(false); //you can't see me!
				frmIzvjetaj.dispose();
			}
		});

	}
}
