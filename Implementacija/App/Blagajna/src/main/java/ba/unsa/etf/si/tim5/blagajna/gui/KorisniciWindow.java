package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipKorisnika;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.log.Log;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KorisniciWindow {

	private JFrame frmKorisnici;	
	private JTable table;
	private Connection conn;
	protected Component frame;
	
	private ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	private Korisnik k;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisniciWindow window = new KorisniciWindow();
					window.frmKorisnici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KorisniciWindow() {
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
	String myDriver = "ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik"; //de me odvedi na klasu
    String myUrl = "jdbc:mysql://localhost/tim5"; //sto nece na online onda o.O cekk
    Class.forName(myDriver);
    conn = (Connection)DriverManager.getConnection(myUrl, "root", "");
}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKorisnici = new JFrame();
		frmKorisnici.setTitle("Korisnici");
		frmKorisnici.setBounds(100, 100, 593, 425);
		frmKorisnici.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("71px:grow"),
				ColumnSpec.decode("95px:grow"),
				ColumnSpec.decode("129px:grow"),
				ColumnSpec.decode("128px:grow"),
				ColumnSpec.decode("131px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("33px"),
				RowSpec.decode("fill:269px:grow"),
				RowSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,});
		frmKorisnici.getContentPane().setLayout(formLayout);
				
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);	
		frmKorisnici.getContentPane().add(scrollPane, "2, 3, 5, 2");
		
		table = new JTable();
		
		final DefaultTableModel tmodel = new DefaultTableModel() {
	    	public boolean isCellEditable(int row, int column){return false;}
	   	    
	    };
	    
	    table.getTableHeader().setReorderingAllowed(false);
	        
		table.setModel(tmodel);
		table.setRowSelectionAllowed(true);		
		scrollPane.setViewportView(table);
		
		
		tmodel.addColumn("ID");
		tmodel.addColumn("Ime");
		tmodel.addColumn("Prezime");
		tmodel.addColumn("JMBG");
		tmodel.addColumn("Adresa");
		tmodel.addColumn("Telefon");
		tmodel.addColumn("E-mail");
		tmodel.addColumn("Tip");
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosKorisnikaWindow window= new UnosKorisnikaWindow();
				window.frmUnosKorisnika.setVisible(true); 
				
			}
		});
		frmKorisnici.getContentPane().add(btnDodaj, "3, 5, center, default");
		
		
		JButton btnUredi = new JButton("Detalji/Uredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int indexSelektovani = table.getSelectedRow();
				long idKorisnika = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));
				
				korisnici = Dao.getInstance().dajSveKorisnike();
				
				for(int i=0;i<korisnici.size();i++){
					if(korisnici.get(i).getId()==idKorisnika){
						UnosKorisnikaWindow window1= new UnosKorisnikaWindow(korisnici.get(i));
						window1.frmUnosKorisnika.setVisible(true);
						
					}
				}
				
				
			}
		});
		frmKorisnici.getContentPane().add(btnUredi, "4, 5, center, default");
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				int indexSelektovani = table.getSelectedRow();
				long idKorisnika = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));
				
				korisnici = Dao.getInstance().dajSveKorisnike();
				Session session = HibernateUtil.getSessionFactory().openSession();
				for(int i=0;i<korisnici.size();i++){
					if(korisnici.get(i).getId()==idKorisnika){
					korisnici.get(i).obrisiKorisnika(session);
					JOptionPane.showMessageDialog(frame,"Izbrisali ste korisnika "+korisnici.get(i).getIme()+" "+ korisnici.get(i).getPrezime()+"!");
					}
				}
				
				session.close();
				((DefaultTableModel)table.getModel()).removeRow(indexSelektovani);
			}
		});
		frmKorisnici.getContentPane().add(btnObrisi, "5, 5, center, default");
		
		
		FillTable(tmodel);
	}
	
	public TipKorisnika ToTipKorisnika(String s){
		if(s=="Korisnik") return TipKorisnika.values()[0];
		else return TipKorisnika.values()[1];
	}
	
	private void FillTable(DefaultTableModel tmodel)
	{
		try {
			String query = "SELECT * FROM korisnik";
			 
		      Statement st = (Statement)conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {
		        
		    	  Korisnik k = new Korisnik();
		    	  k.setId(rs.getLong("id"));
		    	  k.setIme(rs.getString("ime"));
		    	  k.setPrezime(rs.getString("prezime"));
		    	  k.setJmbg(rs.getString("jmbg"));
		    	  k.setAdresa(rs.getString("adresa"));
		    	  k.setTelefon(rs.getString("telefon"));
		    	  k.setMail(rs.getString("mail"));
		    	  k.setTipKorisnika(ToTipKorisnika(rs.getString("tipkorisnika")));
		    	  
		          
		    	  korisnici.add(k);
		    	  tmodel.addRow(new Object[] { k.getId(),k.getIme(), k.getPrezime(),k.getJmbg(),k.getAdresa(),k.getTelefon(),k.getMail(),k.getTipKorisnika()});
		      }
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	

}
