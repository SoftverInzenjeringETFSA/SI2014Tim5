package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.log.Log;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;

public class KupiLiteraturuWindow {

	private JFrame frmKupovinaLiterature;
	private Connection conn;
	ArrayList<Literatura> Knjige;
	JComboBox comboBox;
	private JLabel lblisbn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KupiLiteraturuWindow window = new KupiLiteraturuWindow();
					window.frmKupovinaLiterature.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public KupiLiteraturuWindow(){
		try {
			OpenConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	private void OpenConnection() throws SQLException, ClassNotFoundException
	{
		String myDriver = "ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura"; //de me odvedi na klasu
	    String myUrl = "jdbc:mysql://localhost/tim5"; //sto nece na online onda o.O cekk
	    Class.forName(myDriver);
	    conn = (Connection)DriverManager.getConnection(myUrl, "root", "");
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKupovinaLiterature = new JFrame();
		frmKupovinaLiterature.setTitle("Kupovina literature");
		frmKupovinaLiterature.setBounds(100, 100, 450, 353);
		frmKupovinaLiterature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblimeIPrezime = new JLabel("{ime i prezime}");
		frmKupovinaLiterature.getContentPane().add(lblimeIPrezime, "6, 4");
		
		JLabel lblIsbin = new JLabel("Odaberi:");
		frmKupovinaLiterature.getContentPane().add(lblIsbin, "4, 8, right, default");
		
		comboBox = new JComboBox();
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
		
		JLabel lblisbn = new JLabel("{isbn}");
		panel.add(lblisbn, "4, 4");
		
		JLabel lblNaziv = new JLabel("Naziv:");
		panel.add(lblNaziv, "2, 6");
		
		JLabel lblnaziv = new JLabel("{naziv}");
		panel.add(lblnaziv, "4, 6");
		
		JLabel lblAutor = new JLabel("Autor:");
		panel.add(lblAutor, "2, 8");
		
		JLabel lblautor = new JLabel("{autor}");
		panel.add(lblautor, "4, 8");
		
		JLabel lblCijena = new JLabel("Cijena:");
		panel.add(lblCijena, "2, 10");
		
		JLabel lblcijena = new JLabel("{cijena}");
		panel.add(lblcijena, "4, 10");
		
		JLabel label = new JLabel("Koli\u010Dina:");
		panel.add(label, "2, 12");
		
		JLabel label_1 = new JLabel("{kolicina}");
		panel.add(label_1, "4, 12");
		
		JButton btnKupi = new JButton("Kupi");
		btnKupi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frmKupovinaLiterature.getContentPane().add(btnKupi, "6, 12");
		
		Knjige = new ArrayList<Literatura>();
		FillCombo();
		
	}
	
	
	
	private void FillCombo()
	{
		try {
			String query = "SELECT * FROM Literatura";
			 
		      Statement st = (Statement)conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      String  naziv;
		      while (rs.next())
		      {
		        
		    	  Literatura l = new Literatura();
		    	  l.setNaziv(rs.getString("naziv"));
		    	  l.setId(rs.getLong("id"));
		    	  l.setAutor(rs.getString("autor"));
		    	  l.setIsbn(rs.getString("isbn"));
		    	  l.setKolicina(rs.getInt("kolicina"));
		    	  l.setCijena(rs.getDouble("cijena"));
		    	  
		    
		          
		    	  Knjige.add(l);
		    	  comboBox.addItem(l.getNaziv());
		      }
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
