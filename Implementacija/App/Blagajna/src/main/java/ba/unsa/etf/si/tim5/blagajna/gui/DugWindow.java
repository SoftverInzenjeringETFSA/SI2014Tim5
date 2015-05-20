package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.GodinaStudija;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Rata;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DugWindow {
		
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
	private String result = "";
	
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
	
	public DugWindow()
	{
		ArrayList<Student> studenti = Dao.getInstance().dajSveStudente();
		student = studenti.get(9);
		initialize();
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
		
		String[] comboBoxArray = {"2014/2015", "2013/2014","2012/2013","2011/2012","2010/2011"};

		StudijskaGodinaCB = new JComboBox(comboBoxArray);

		
		
		StudijskaGodinaCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studijskaGodina =StudijskaGodinaCB.getSelectedItem().toString();
			}
		});
		
		
		frmDugovanjaUplate.getContentPane().add(StudijskaGodinaCB, "9, 4, fill, default");
		table = new JTable();
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
		JScrollPane TabelaDugova = new JScrollPane(table);
		frmDugovanjaUplate.getContentPane().add(TabelaDugova, "3, 8, 7, 1, fill, fill");
		
		ArrayList<Dug> dugovi;
		
	Session session = HibernateUtil.getSessionFactory().openSession();
		
		dugovi = student.dajSveDugove(session);
		
		
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		for (int i =0;i<dugovi.size();i++)
		{
			ArrayList<Rata> rate = dugovi.get(i).dajSveRate(session);
			for (int j = 0;j<rate.size();j++)
				model.addRow(new Object[] {rate.get(j).getId(), rate.get(j).getVrijednost(), rate.get(j).getDatumZaduzenja(), rate.get(j).getDatumRazduzenja(), rate.get(j).getRokUplate(), dugovi.get(i).getTipDuga() });
		}
		session.close();
		
		

		
		lblUkupanDug = new JLabel("Ukupan dug:");
		frmDugovanjaUplate.getContentPane().add(lblUkupanDug, "7, 12");
	
		
		
		lblDug = new JLabel("{dug}");
		frmDugovanjaUplate.getContentPane().add(lblDug, "9, 12");
		
		btnUplati = new JButton("Uplati");
		btnUplati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		frmDugovanjaUplate.getContentPane().add(btnUplati, "3, 14, 7, 1");
		
		btnPrintaj = new JButton("Printaj potvrdu");
		
		btnPrintaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*		try
				{
					table.print();
				}
				catch (PrinterException pe) {
			          System.err.println("Error printing: " + pe.getMessage());
		        }				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();

				Calendar now = Calendar.getInstance();
				result = "\n"+"\n"+ "International University of Sarajevo"+"\n" +
							"Zagrebacka bb"+"\n" +
							"+38733911911"+"\n" +"\n" +
							"Student " + student.getIme() + " ("+ student.getImeRoditelja() + ") " +student.getPrezime() + "je uplatio dug čiji je id i vrijednost.";
					result = result + "\n" +"\n" + "\nDatum: " + date + "\n";
						
			*/	
			}
			});
		
		frmDugovanjaUplate.getContentPane().add(btnPrintaj, "3, 18, 7, 1, default, top");
	/*	
		
		class btnPrintAction implements ActionListener, Printable{
	         
			  public int print(Graphics gx, PageFormat pf, int page) throws PrinterException {
			             if (page>0){return NO_SUCH_PAGE;} 
			             Graphics2D g = (Graphics2D)gx; 
			             g.translate(pf.getImageableX(), pf.getImageableY()); 
			             g.drawString ("Hello world", 100, 100); 
			             return PAGE_EXISTS; 
			         }
			  
			 public void actionPerformed(ActionEvent e) {
			             PrinterJob job = PrinterJob.getPrinterJob(); 
			             job.setPrintable(this); 
			             if (job.printDialog() == true) { 
			                 try {job.print();} catch (PrinterException ex){
			                 }
			             }
			         }
		  	}
		

	*/

		
		//frame.getContentPane().add(table, "2, 4, fill, fill");
	}

}
