package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Connection;

public class KorisniciWindow {

	JFrame frmKorisnici;
	private JTable table;	
	protected Component frame;
	final static Logger logger = Logger.getLogger(UnosKorisnikaWindow.class);
	private ArrayList<Korisnik> korisnici;
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
					logger.info(e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public KorisniciWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKorisnici = new JFrame();
		frmKorisnici.setTitle("Korisnici");
		frmKorisnici.setBounds(100, 100, 593, 425);
		frmKorisnici.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FormLayout formLayout = new FormLayout(
				new ColumnSpec[] { FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("71px:grow"),
						ColumnSpec.decode("95px:grow"),
						ColumnSpec.decode("129px:grow"),
						ColumnSpec.decode("128px:grow"),
						ColumnSpec.decode("131px:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"), RowSpec.decode("33px"),
						RowSpec.decode("fill:269px:grow"),
						RowSpec.decode("max(25dlu;default)"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, });
		frmKorisnici.getContentPane().setLayout(formLayout);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frmKorisnici.getContentPane().add(scrollPane, "2, 3, 5, 2");

		table = new JTable();

		final DefaultTableModel tmodel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

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
				UnosKorisnikaWindow window = new UnosKorisnikaWindow(korisnici, table);
				window.frmUnosKorisnika.setVisible(true);

			}
		});
		frmKorisnici.getContentPane().add(btnDodaj, "3, 5, center, default");

		JButton btnUredi = new JButton("Detalji/Uredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int indexSelektovani = table.getSelectedRow();
			if(table.getSelectedRowCount()!=0){
				long idKorisnika = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));

				Korisnik k = Dao.getInstance().dajKorisnikaPoId(idKorisnika);

				UnosKorisnikaWindow window1 = new UnosKorisnikaWindow(k, table, indexSelektovani);
				window1.frmUnosKorisnika.setVisible(true);
			}
			else 
			{
				JOptionPane.showMessageDialog(frame,
						"Odaberite korisnika za izmjenu prvo.",
					    "Odaberite korisnika",
					    JOptionPane.ERROR_MESSAGE);
			}

			}
		});
		frmKorisnici.getContentPane().add(btnUredi, "4, 5, center, default");

		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRowCount()!=0){
				try{
				int indexSelektovani = table.getSelectedRow();
				long idKorisnika = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));

				Korisnik k = Dao.getInstance().dajKorisnikaPoId(idKorisnika);
				Session session = HibernateUtil.getSessionFactory()
						.openSession();

				k.obrisiKorisnika(session);
				korisnici.remove(k);
				JOptionPane.showMessageDialog(frame, "Izbrisali ste korisnika "
						+ k.getIme() + " " + k.getPrezime() + ".",
						"Korisnik izbrisan",
					    JOptionPane.PLAIN_MESSAGE);
				logger.info("Izbrisali ste korisnika " + k.getIme() + " " + k.getPrezime()+".");
				session.close();
				((DefaultTableModel) table.getModel())
						.removeRow(indexSelektovani);
				}
				catch(Exception ex){
					ex.printStackTrace();
					logger.error("Greška kod brisanja korisnika "+ k.getIme() + " " + k.getPrezime() + "." + ex.getMessage() , ex);
				}
				}
				else
				{
					JOptionPane.showMessageDialog(frame,
							"Odaberite korisnika za brisanje prvo.",
						    "Odaberite korisnika",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frmKorisnici.getContentPane().add(btnObrisi, "5, 5, center, default");

		FillTable(tmodel);
	}

	private void FillTable(DefaultTableModel tmodel) {
		try {
			korisnici = Dao.getInstance().dajSveKorisnike();
			
			Collections.sort(korisnici, new Comparator<Korisnik>() {
			    public int compare(Korisnik k1, Korisnik k2) {
			        return k1.getIme().compareTo(k2.getIme());
			    }
			});
			
			for (int i = 0; i < korisnici.size(); i++) {
				k = korisnici.get(i);
				tmodel.addRow(new Object[] { k.getId(), k.getIme(),
						k.getPrezime(), k.getJmbg(), k.getAdresa(),
						k.getTelefon(), k.getMail(), k.getTipKorisnika() });
			}
		} catch (Exception e) { //
			e.printStackTrace();
			logger.error("Greška kod popunjavanja tabele! " + e.getMessage() , e);
		}
	}

}
