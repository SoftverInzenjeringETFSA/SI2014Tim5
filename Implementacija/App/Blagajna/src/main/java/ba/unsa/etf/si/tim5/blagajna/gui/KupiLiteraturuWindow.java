package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipDuga;
import ba.unsa.etf.si.tim5.blagajna.dodaci.Utility;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Dug;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class KupiLiteraturuWindow {
	final static Logger logger = Logger.getLogger(KupiLiteraturuWindow.class);
	
	JFrame frmKupovinaLiterature;	
	private Student student;
	ArrayList<Literatura> knjige;
	JComboBox comboBox;
	private JLabel lblisbn;
	private JLabel lblnaziv;
	private JLabel lblautor;
	private JLabel lblkolicina;
	private JLabel lblcijena;
	private JLabel lblimeIPrezime;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//@Override
			public void run() {
				try {
					KupiLiteraturuWindow window = new KupiLiteraturuWindow();
					window.frmKupovinaLiterature.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Greška pri otvaranju forme za kupovinu literature! " + e.getMessage() , e);
					//logger.log(Priority.ERROR, e.getMessage(), e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public KupiLiteraturuWindow(Student s){
		initialize();
		this.student = s;
		lblimeIPrezime.setText(s.getIme() + " " + s.getPrezime());
	}
	public KupiLiteraturuWindow(){		
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKupovinaLiterature = new JFrame();
		frmKupovinaLiterature.setTitle("Kupovina literature");
		frmKupovinaLiterature.setBounds(100, 100, 450, 353);
		frmKupovinaLiterature.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmKupovinaLiterature.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(107dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStudent = new JLabel("Student:");
		frmKupovinaLiterature.getContentPane().add(lblStudent, "4, 4");
		
		lblimeIPrezime = new JLabel("{ime i prezime}");
		frmKupovinaLiterature.getContentPane().add(lblimeIPrezime, "6, 4");
		
		JLabel lblIsbin = new JLabel("Odaberi:");
		frmKupovinaLiterature.getContentPane().add(lblIsbin, "4, 8, right, default");
		
		comboBox = new JComboBox();
	
		comboBox.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				Literatura l = (Literatura)comboBox.getSelectedItem();
				FillLabels(l);
			}
		});
		frmKupovinaLiterature.getContentPane().add(comboBox, "6, 8, fill, default");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Detalji"));
		frmKupovinaLiterature.getContentPane().add(panel, "4, 10, 3, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				RowSpec.decode("default:grow"),}));
		
		JLabel lblIsbn = new JLabel("ISBN:");
		panel.add(lblIsbn, "2, 4");
		
		lblisbn = new JLabel("{isbn}");
		panel.add(lblisbn, "4, 4");
		
		JLabel lblNaziv = new JLabel("Naziv:");
		panel.add(lblNaziv, "2, 6");
		
		lblnaziv = new JLabel("{naziv}");
		panel.add(lblnaziv, "4, 6");
		
		JLabel lblAutor = new JLabel("Autor:");
		panel.add(lblAutor, "2, 8");
		
		lblautor = new JLabel("{autor}");
		panel.add(lblautor, "4, 8");
		
		JLabel lblCijena = new JLabel("Cijena:");
		panel.add(lblCijena, "2, 10");
		
		lblcijena = new JLabel("{cijena}");
		panel.add(lblcijena, "4, 10");
		
		JLabel label = new JLabel("Koli\u010Dina:");
		panel.add(label, "2, 12");
		
		lblkolicina = new JLabel("{kolicina}");
		panel.add(lblkolicina, "4, 12");
		
		JButton btnKupi = new JButton("Kupi");
		btnKupi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Literatura l = (Literatura)comboBox.getSelectedItem();
				if(l.getKolicina() == 0) {
					JOptionPane.showMessageDialog(null,"Odabrane knjige nema više! ","Problem",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String godina =  Utility.getInstance().dajStudijskuGodinu();
				Dug d = new Dug(69, false, godina,
				l.getCijena(), student.getId(), TipDuga.dugZaLiteraturu);				
				Session session = HibernateUtil.getSessionFactory().openSession();
				d.dodajDug(session);
				student.setTroskoviLiterature(student.getTroskoviLiterature() + l.getCijena());
				student.urediStudenta(session);
				session.close();
				JOptionPane.showMessageDialog(null,"Literatura je zadužena!","OK",JOptionPane.INFORMATION_MESSAGE);
				
				logger.info("Zaduzena literatura" + l.getId()+ " , " + l.getNaziv());
			}
		});
		frmKupovinaLiterature.getContentPane().add(btnKupi, "4, 12");
		
		JButton btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKupovinaLiterature.setVisible(false); //you can't see me!
				frmKupovinaLiterature.dispose();
			}
		});
		frmKupovinaLiterature.getContentPane().add(btnIzai, "6, 12, right, default");
				
		FillCombo();
		
	}
	
	private void FillLabels(Literatura l) {
		lblisbn.setText(l.getIsbn());
		lblnaziv.setText(l.getNaziv());
		lblautor.setText(l.getAutor());
		lblkolicina.setText(String.valueOf(l.getKolicina()));
		lblcijena.setText(String.valueOf(l.getCijena()));
	}
	
	
	private void FillCombo()
	{
		knjige = Dao.getInstance().dajSvuLiteraturu();
		for(int i=0; i<knjige.size(); i++) {
			comboBox.addItem(knjige.get(i));
		}
	}
}
