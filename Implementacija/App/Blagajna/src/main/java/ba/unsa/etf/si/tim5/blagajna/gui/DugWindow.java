package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.print.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.exception.DRException;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.util.*;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.SlanjeMaila;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
public class DugWindow {
	final static Logger logger = Logger.getLogger(DugWindow.class);
	
	JFrame frmDugovanjaUplate;
	private JTable table;
	private JLabel lblStudent;
	private JLabel lblimeIPrezime;
	private JLabel lblStudijskaGodina;
	private JComboBox StudijskaGodinaCB;
	private JLabel lblUkupanDug;
	private JLabel lblDug;
	private JButton btnUplati;
	private JButton btnPrintaj;
	private Student student;
	ArrayList<Dug> dugovi;
	ArrayList<Rata> rate;	
	
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
					logger.error("Greška pri otvaranju forme za dugove! " + e.getMessage() , e);
				}
			}
		});
	}
	
	public DugWindow()
	{
		try {
		ArrayList<Student> studenti = Dao.getInstance().dajSveStudente();
		student = studenti.get(1);
		initialize();
		}
		catch(Exception e) 
		{ 
			e.printStackTrace();

			logger.error("Greška - DugWindow() " + e.getMessage() , e);
		}
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
		lblimeIPrezime.setText(student.getIme()+" "+student.getPrezime());
		
		frmDugovanjaUplate.getContentPane().add(lblimeIPrezime, "5, 4");
		
		lblStudijskaGodina = new JLabel("Studijska godina:");
		frmDugovanjaUplate.getContentPane().add(lblStudijskaGodina, "7, 4, right, default");
		
		String[] comboBoxArray = {"2014/2015", "2013/2014","2012/2013","2011/2012","2010/2011"};

		StudijskaGodinaCB = new JComboBox(comboBoxArray);

		
		StudijskaGodinaCB.addActionListener(new ActionListener() {
			//@Override
			
			public void actionPerformed(ActionEvent e) {
				popuniTabelu();
			}
		});
		
		
		
		
		frmDugovanjaUplate.getContentPane().add(StudijskaGodinaCB, "9, 4, fill, default");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);
		
	    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
	        @Override
	        
	        public Component getTableCellRendererComponent(JTable table,
	                Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	            
	        	super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	            
	            if (hasFocus) setBackground(Color.DARK_GRAY);
	            
	            String datum = (String)table.getModel().getValueAt(row, 3);
	            if (datum == "") {
	                setBackground(Color.RED);
	            }   
	            else 
	            {
	            	setBackground(Color.WHITE);
	            }
	            return this;
	        }   
	    });
	    

		final DefaultTableModel model = new DefaultTableModel(new Object[][] {
		}, new String[] {
			"Id", "Dug", "Datum zadu\u017Eenja", "Datum razdu\u017Eenja", "Rok za uplatu", "Tip duga"
		}) 
		{

			private static final long serialVersionUID = 8947897896919412127L;
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
	    };
	    
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Id", "Dug", "Datum zadu\u017Eenja", "Datum razdu\u017Eenja", "Rok za uplatu", "Tip duga"
	    	}
	    ));
	    table.getColumnModel().getColumn(0).setMinWidth(7);
	    table.getColumnModel().getColumn(2).setMinWidth(18);
	    table.getColumnModel().getColumn(3).setMinWidth(18);
		JScrollPane TabelaDugova = new JScrollPane(table);	frmDugovanjaUplate.getContentPane().add(TabelaDugova, "3, 8, 7, 1, fill, fill");
		
		popuniTabelu();
		lblUkupanDug = new JLabel("Ukupan dug:");
		frmDugovanjaUplate.getContentPane().add(lblUkupanDug, "7, 12");
		double ukupanDugD = student.dajUkupniDug();
		int ukupanDugI = (int)ukupanDugD;
		String s = Integer.toString(ukupanDugI);
		lblDug = new JLabel(s);
		frmDugovanjaUplate.getContentPane().add(lblDug, "9, 12");
		btnUplati = new JButton("Uplati");
		btnUplati.addActionListener(new ActionListener() {
			//@Override
			
			public void actionPerformed(ActionEvent e) {			
				if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(null,"Odaberite ratu koju želite da uplatite !","Message",JOptionPane.INFORMATION_MESSAGE);
			else
			{		
				int red = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(red, 0).toString());
		
			for (int i =0;i<rate.size();i++)
				if (rate.get(i).getId()==id)
				if (!rate.get(i).isJeLiUplacena())
				{
					Session session = HibernateUtil.getSessionFactory().openSession();
					rate.get(i).setJeLiUplacena(true);
					rate.get(i).setDatumRazduzenja(new Date());
					rate.get(i).urediRatu(session);
					session.close();
					for (int j = 0;j<dugovi.size();j++)
						if (dugovi.get(j).getId()==rate.get(i).getDugId())
						{
							Session session1 = HibernateUtil.getSessionFactory().openSession();
							dugovi.get(j).setVrijednost(dugovi.get(j).getVrijednost()-rate.get(i).getVrijednost());
							if (dugovi.get(j).getVrijednost()<1) dugovi.get(j).setJeLiIzmiren(true);
							dugovi.get(j).urediDug(session1);
							session1.close();	
						}
					popuniTabelu();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Rata je vec uplacena !","Message",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			}
		});
		
		frmDugovanjaUplate.getContentPane().add(btnUplati, "3, 14, 7, 1");
		
		btnPrintaj = new JButton("Printaj potvrdu");
		
		btnPrintaj.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
		 if (table.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(null,"Odaberite ratu za koju želite isprintati potvrdu !","Message",JOptionPane.INFORMATION_MESSAGE);
				else
				{
				int red = table.getSelectedRow();
				String dug = table.getValueAt(red, 1).toString();
				String datum = table.getValueAt(red, 3).toString();
				
				try
				{
				GenerisiIzvjestaj(student.getIme(), student.getPrezime(), student.getImeRoditelja(), dug, datum);
				}
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					logger.error("Greška pri generisanju fajla za printanje! " + e1.getMessage() , e1);
				} 
				catch (DRException e1) {
					
					e1.printStackTrace();
					logger.error("Greška pri generisanju izvještaja za printanje! " + e1.getMessage() , e1);
				}
					
				
				}
		 }
	});
		frmDugovanjaUplate.getContentPane().add(btnPrintaj, "3, 18, 7, 1, default, top");
	}	
		

	private void popuniTabelu() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		dugovi = student.dajSveDugove(session);
		String s = "";
		s = (String)StudijskaGodinaCB.getSelectedItem();
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for (int i =0;i<dugovi.size();i++)
		{		
			if (dugovi.get(i).getAkademskaGodina().toString().equals(s))
			{	
			rate = dugovi.get(i).dajSveRate(session);
			for (int j = 0;j<rate.size();j++)
			{
				String datum1, datum2, datum3;
				datum1 = dajDatum(rate.get(j).getDatumZaduzenja());
				
				datum2 = dajDatum(rate.get(j).getDatumRazduzenja());
				datum3 = dajDatum(rate.get(j).getRokUplate());
				String tipDuga;
				tipDuga = dugovi.get(i).getTipDuga().toString();
				if (tipDuga.equals("dugZaSkolarinu")) tipDuga = "Dug za školarinu";
				else tipDuga = "Dug za literaturu";
				model.addRow(new Object[] {rate.get(j).getId() , (int)rate.get(j).getVrijednost(), datum1, datum2, datum3, tipDuga });
			}
		}
		}
		session.close();
	}
		// TODO Auto-generated method stub

	protected String dajDatum(Date datum) {
		if (datum == null) return "";
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String s = dateFormat.format(datum).toString();
		return s;
	}
	
	public void GenerisiIzvjestaj(String ime, String prezime, String imeRoditelja, String dug, String datum) throws FileNotFoundException, DRException
	{
		//dynamic report
		JasperReportBuilder report = DynamicReports.report(); 
		//add title
		TextFieldBuilder<String> title1 = DynamicReports.cmp.text("  International Technical University\n"); 
		report.title(title1); 
		TextFieldBuilder<String> title2 = DynamicReports.cmp.text("  Zmaja od Bosne bb, Kampus Univerziteta u Sarajevu, 71 000 Sarajevo\n"); 
		report.title(title2); 
		TextFieldBuilder<String> title3 = DynamicReports.cmp.text("  Tel: ++387 33 250 700\n\n\n\n"); 
		report.title(title3);
		if (datum != "")
		{
			TextFieldBuilder<String> title4 =DynamicReports.cmp.text("   Ovaj dokument se izdaje kao potvrda da je student " + ime + " (" + imeRoditelja+ ") " + prezime + " izmirio/la ratu duga prema Univerzitetu u vrijednosti od "+dug+" KM na datum " + datum +".\n\n\n\n");
			report.title(title4);
		}
		else
		{
			TextFieldBuilder<String> title4 =DynamicReports.cmp.text("   Ovaj dokument se izdaje kao potvrda da student " + ime + " (" + imeRoditelja+ ") " + prezime + " nije izmirio/la ratu duga Univerzitetu u vrijednosti od "+dug+" KM.\n\n\n\n");
			report.title(title4);
		}
		TextFieldBuilder<String> title5 =DynamicReports.cmp.text("Potpis ovlaštenog lica: ___________________ \n");
		report.title(title5);
		TextFieldBuilder<String> title6 =DynamicReports.cmp.text("Potpis studenta:        ___________________ \n");
		report.title(title6);
		Date date = new Date();
		String s = dajDatum(date);
		TextFieldBuilder<String> title7 = DynamicReports.cmp.text("Datum: " + s); 
		report.title(title7); 		
		report.show(); 		
	}
}	// TODO Auto-generated method stub
		


