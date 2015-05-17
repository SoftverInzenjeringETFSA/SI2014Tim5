package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTextPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

//----------------------dodano
import javax.swing.JFrame;
//----------------------
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import org.hibernate.Session;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Mjesec;
import ba.unsa.etf.si.tim5.blagajna.dodaci.TipIzvjestaja;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Izvjestaj;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class IzvjestajWindow {

	private JFrame frmIzvjetaj;
	//----------------------dodano
	private Izvjestaj izvjestaj;
	
	//---------------------- 
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaj = new JFrame();
		frmIzvjetaj.setTitle("Izvje\u0161taj");
		frmIzvjetaj.setBounds(100, 100, 557, 444);
		frmIzvjetaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaj.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("29px"),
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
				ColumnSpec.decode("55px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("239px"),
				RowSpec.decode("21px"),
				RowSpec.decode("23px"),}));
		
		
		//----------------------dodano
		
		this.izvjestaj = new Izvjestaj();
		
		//----------------------
		
		JLabel lblTipIzvjetaja = new JLabel("Tip izvje\u0161taja:");
		frmIzvjetaj.getContentPane().add(lblTipIzvjetaja, "2, 2, right, center");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipIzvjestaja.values()));
		frmIzvjetaj.getContentPane().add(comboBox, "4, 2, fill, center");
		
		JLabel lblMjesec = new JLabel("Mjesec:");
		frmIzvjetaj.getContentPane().add(lblMjesec, "6, 2, right, center");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Mjesec.values()));
		frmIzvjetaj.getContentPane().add(comboBox_1, "8, 2, fill, center");
		
		//JButton btnGenerii = new JButton("Generi\u0161i izvje\u0161taj");
		//frmIzvjetaj.getContentPane().add(btnGenerii, "2, 4, 13, 1, fill, center");
		
		JLabel lblPrikazIzvjetaja = new JLabel("Prikaz izvje\u0161taja:");
		frmIzvjetaj.getContentPane().add(lblPrikazIzvjetaja, "2, 6, 3, 1, center, center");
		
		final JTextPane textPane = new JTextPane();
		frmIzvjetaj.getContentPane().add(textPane, "2, 8, 13, 1, fill, fill");

		JButton btnNewButton = new JButton("Printaj");
		frmIzvjetaj.getContentPane().add(btnNewButton, "2, 10, center, center");
		
		JButton btnIzai = new JButton("Iza\u0111i");
		frmIzvjetaj.getContentPane().add(btnIzai, "12, 10, 3, 1, right, center");
	
		//----------------------dodano
	JButton btnGenerisi = new JButton("Generi\u0161i izvje\u0161taj");
	btnGenerisi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Izvjestaj i = new Izvjestaj();
			 //textPane.replaceSelection(izvjestaj.getSadrzaj());
			textPane.setText("");
			String result = "";
			result = "Izvjestaj datum: " + izvjestaj.getDatum() + "\n" +
						"Izvjestaj sadrzaj: " + izvjestaj.getSadrzaj() + "\n" +
						"Izvjestaj korisnik: " + izvjestaj.getKorisnikId() ;
		
			
            textPane.setText(result);
		}
	});
	
	
	frmIzvjetaj.getContentPane().add(btnGenerisi, "2, 4, 13, 1, fill, center");
	
	/*btnGenerisi.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent event) {
	    	  textPane.replaceSelection(izvjestaj.getSadrzaj());
	    	  
	    	//  Session session = HibernateUtil.getSessionFactory().openSession();
	    	//  izvjestaj.dodajIzvjestaj(session);
	    	//  session.close();
	      }
	    });*/
	
	
	
	btnIzai.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand().equals("Iza\u0111i")) {
			 
			 System.exit(0);
		 }
		}
	});
	
	

	
	
	}
}
