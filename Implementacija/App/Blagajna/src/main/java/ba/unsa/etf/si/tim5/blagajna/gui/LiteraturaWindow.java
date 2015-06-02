package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class LiteraturaWindow {
	
	final static Logger logger = Logger.getLogger(LiteraturaWindow.class);
	
	JFrame frmUnosDugaZa;
	private JTable table;
	private JLabel lblPrikazLiterature;
	private JPanel panel;
	private JLabel lblIsbn;
	private JLabel lblNaziv;
	private JLabel lblAutor;
	private JLabel lblKoliina;
	private JLabel lblCijena;
	private JTextField tFieldIsbn;
	private JTextField tFieldNaziv;
	private JTextField tFieldAutor;
	private JTextField tFieldKolicina;
	private JTextField tFieldCijena;
	private JButton btnUnesi;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiteraturaWindow window = new LiteraturaWindow();
					window.frmUnosDugaZa.setVisible(true);
				} catch (Exception e) {					
					logger.error(e.getMessage() , e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private ArrayList<Literatura> literatura;
	private JButton btnIzai;
	
	private void inicijalizirajTabelu() {
		ArrayList<Literatura> l = Dao.getInstance().dajSvuLiteraturu();			
		literatura = l;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for(int i = 0; i<l.size(); i++)
		model.addRow(new Object[] { l.get(i).getId(), l.get(i).getIsbn(),
				l.get(i).getNaziv(),l.get(i).getAutor(), l.get(i).getKolicina(),
				l.get(i).getCijena() });		
	}
	
	public LiteraturaWindow() {
		initialize();
		inicijalizirajTabelu();		

	}



	public LiteraturaWindow(ArrayList<Literatura> literatura) {
		initialize();
		this.setLiteratura(literatura);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosDugaZa = new JFrame();
		frmUnosDugaZa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmUnosDugaZa.dispose();
			}
		});
		frmUnosDugaZa.setTitle("Literatura");
		frmUnosDugaZa.setBounds(100, 100, 467, 544);
		frmUnosDugaZa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUnosDugaZa.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(62dlu;default):grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		lblPrikazLiterature = new JLabel("Prikaz literature");
		frmUnosDugaZa.getContentPane().add(lblPrikazLiterature, "4, 4");

		table = new JTable();
		final DefaultTableModel tmodel = new DefaultTableModel(new Object[][] { }, new String[] { "Id", "ISBN",
				"Naziv", "Autor", "Koli\u010Dina", "Cijena" }) {
	    	/**
					 * 
					 */
					private static final long serialVersionUID = -3390677526490666016L;

			public boolean isCellEditable(int row, int column){return false;}
	   	    
	    };
	    table.setModel(tmodel);
	    table.getTableHeader().setReorderingAllowed(false);
		//table.setModel(new DefaultTableModel(new Object[][] { }, new String[] { "Id", "ISBN",
		//		"Naziv", "Autor", "Koli\u010Dina", "Cijena" }));
		// frmUnosDugaZa.getContentPane().add(table, "4, 4, fill, fill");

		JScrollPane scrollPane = new JScrollPane(table);
		frmUnosDugaZa.getContentPane()
				.add(scrollPane, "4, 6, 5, 3, fill, fill");

		btnNewButton = new JButton("Obri\u0161i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexSelektovani = table.getSelectedRow();
				long idLiteratura = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));
				
				Literatura l = Dao.getInstance().dajLiteraturuPoId(idLiteratura);
				Session session = HibernateUtil.getSessionFactory().openSession();
				l.obrisiLiteraturu(session);
				session.close();
				((DefaultTableModel)table.getModel()).removeRow(indexSelektovani);
			}
		});
		frmUnosDugaZa.getContentPane().add(btnNewButton, "6, 10, 3, 1");

		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Unos literature"));
		frmUnosDugaZa.getContentPane().add(panel, "4, 14, 5, 1, fill, fill");
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(152dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		lblIsbn = new JLabel("ISBN:");
		panel.add(lblIsbn, "2, 4, right, default");

		tFieldIsbn = new JTextField();
		panel.add(tFieldIsbn, "4, 4, fill, default");
		tFieldIsbn.setColumns(10);

		lblNaziv = new JLabel("Naziv:");
		panel.add(lblNaziv, "2, 6, right, default");

		tFieldNaziv = new JTextField();
		panel.add(tFieldNaziv, "4, 6, fill, default");
		tFieldNaziv.setColumns(10);

		lblAutor = new JLabel("Autor:");
		panel.add(lblAutor, "2, 8, right, default");

		tFieldAutor = new JTextField();
		panel.add(tFieldAutor, "4, 8, fill, default");
		tFieldAutor.setColumns(10);

		lblKoliina = new JLabel("Koli\u010Dina:");
		panel.add(lblKoliina, "2, 10, right, default");

		tFieldKolicina = new JTextField();
		panel.add(tFieldKolicina, "4, 10, fill, default");
		tFieldKolicina.setColumns(10);

		lblCijena = new JLabel("Cijena:");
		panel.add(lblCijena, "2, 12, right, default");

		tFieldCijena = new JTextField();
		panel.add(tFieldCijena, "4, 12, fill, default");
		tFieldCijena.setColumns(10);

		btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = tFieldIsbn.getText();
				String naziv = tFieldNaziv.getText();
				String autor = tFieldAutor.getText();
				int kolicina = Integer.parseInt(tFieldKolicina.getText());
				double cijena = Double.parseDouble(tFieldCijena.getText());

				Literatura l;

				try {
				 l = new Literatura(69, isbn, naziv, autor, kolicina,cijena);
				}catch(IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null,"ISBN nije validan! ","Problem",JOptionPane.INFORMATION_MESSAGE);
					logger.error("ISBN nije valjan kod unosa!", iae );
					l = null;
					return;
				}
				try {
				Session session = HibernateUtil.getSessionFactory().openSession();

				long id = l.dodajLiteraturu(session); //svoj id dobije tek nakon smjestanja u bazu
				session.close();
				l.setId(id); //potrebno je sada promijeniti id na novi, pa tek onda dodat u tabelu i listu
				literatura.add(l);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { l.getId(), l.getIsbn(),
						l.getNaziv(), l.getAutor(), l.getKolicina(),
						l.getCijena() });
				logger.info("Dodana literatura" + l.getId()+ " , " + l.getNaziv());
				JOptionPane.showMessageDialog(null,"Literatura je dodana!","Message",JOptionPane.INFORMATION_MESSAGE);				
				ocistiPoljaZaUnos();
				}catch(ConstraintViolationException cve) {
					JOptionPane.showMessageDialog(null,"Knjiga sa tim ISBN-om je već unesena! Ako želite unijeti nove primjerke, prvo obrišite postojeću. ","Problem",JOptionPane.INFORMATION_MESSAGE);
					logger.error("Pokušaj unosa već postojeće literature", cve );
					l = null;
					return;
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Problem kod spremanja literature " + ex.getMessage(),"Problem",JOptionPane.INFORMATION_MESSAGE);
					logger.error("Problem kod spremanja literature", ex );
					l = null;
					return;
				}
		
			}
		});
		panel.add(btnUnesi, "4, 16");
		
		btnIzai = new JButton("Izađi");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUnosDugaZa.setVisible(false); //you can't see me!
				frmUnosDugaZa.dispose();
			}
		});
		frmUnosDugaZa.getContentPane().add(btnIzai, "6, 16, right, default");
	}
	
	private void ocistiPoljaZaUnos() {
		tFieldIsbn.setText("");
		tFieldNaziv.setText("");
		tFieldAutor.setText("");
		tFieldKolicina.setText("");
		tFieldCijena.setText("");
	}

	public ArrayList<Literatura> getLiteratura() {
		return literatura;
	}

	public void setLiteratura(ArrayList<Literatura> literatura) {
		this.literatura = literatura;
	}

}
