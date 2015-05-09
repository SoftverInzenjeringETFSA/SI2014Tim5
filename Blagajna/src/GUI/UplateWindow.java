package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UplateWindow {

	private JFrame frmUplate;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UplateWindow window = new UplateWindow();
					window.frmUplate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UplateWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUplate = new JFrame();
		frmUplate.setTitle("Uplate");
		frmUplate.setResizable(false);
		frmUplate.setBounds(100, 100, 786, 415);
		frmUplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{133, 272, 2, 88, 128, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 14, 180, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frmUplate.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblStudent = new JLabel("Student:");
		GridBagConstraints gbc_lblStudent = new GridBagConstraints();
		gbc_lblStudent.anchor = GridBagConstraints.EAST;
		gbc_lblStudent.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudent.gridx = 0;
		gbc_lblStudent.gridy = 1;
		frmUplate.getContentPane().add(lblStudent, gbc_lblStudent);
		
		JLabel lblimeIPrezime = new JLabel("{ime i prezime}");
		GridBagConstraints gbc_lblimeIPrezime = new GridBagConstraints();
		gbc_lblimeIPrezime.anchor = GridBagConstraints.WEST;
		gbc_lblimeIPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblimeIPrezime.gridx = 1;
		gbc_lblimeIPrezime.gridy = 1;
		frmUplate.getContentPane().add(lblimeIPrezime, gbc_lblimeIPrezime);
		
		JLabel lblIndeks = new JLabel("Indeks:");
		GridBagConstraints gbc_lblIndeks = new GridBagConstraints();
		gbc_lblIndeks.anchor = GridBagConstraints.EAST;
		gbc_lblIndeks.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndeks.gridx = 3;
		gbc_lblIndeks.gridy = 1;
		frmUplate.getContentPane().add(lblIndeks, gbc_lblIndeks);
		
		JLabel lblindeks = new JLabel("{indeks}");
		GridBagConstraints gbc_lblindeks = new GridBagConstraints();
		gbc_lblindeks.anchor = GridBagConstraints.WEST;
		gbc_lblindeks.insets = new Insets(0, 0, 5, 5);
		gbc_lblindeks.gridx = 4;
		gbc_lblindeks.gridy = 1;
		frmUplate.getContentPane().add(lblindeks, gbc_lblindeks);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Uplate za školarinu"));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		frmUplate.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 106, 0, 249, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 4.9E-324, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label_5 = new JLabel("Sve uplate:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panel.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("Svi dugovi:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 0;
		panel.add(label_6, gbc_label_6);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		panel.add(list, gbc_list);
		
		JList list_3 = new JList();
		GridBagConstraints gbc_list_3 = new GridBagConstraints();
		gbc_list_3.fill = GridBagConstraints.BOTH;
		gbc_list_3.gridwidth = 3;
		gbc_list_3.insets = new Insets(0, 0, 5, 0);
		gbc_list_3.gridx = 2;
		gbc_list_3.gridy = 1;
		panel.add(list_3, gbc_list_3);
		
		JLabel label_7 = new JLabel("Ukupan dug:");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 2;
		panel.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("{dug}");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 2;
		panel.add(label_8, gbc_label_8);
		
		JLabel label_9 = new JLabel("Naziv uplate:");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 3;
		panel.add(label_9, gbc_label_9);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		
		JLabel label_10 = new JLabel("Vrijednost:");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 4;
		panel.add(label_10, gbc_label_10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		
		JButton button_2 = new JButton("Uplati");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.gridwidth = 4;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 5;
		panel.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("Printaj potvrdu");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridwidth = 4;
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 6;
		panel.add(button_3, gbc_button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Uplate za literaturu"));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 2;
		frmUplate.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 106, 0, 249, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 4.9E-324, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("Sve uplate:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel lblSviDugovi = new JLabel("Svi dugovi:");
		GridBagConstraints gbc_lblSviDugovi = new GridBagConstraints();
		gbc_lblSviDugovi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSviDugovi.gridx = 2;
		gbc_lblSviDugovi.gridy = 0;
		panel_1.add(lblSviDugovi, gbc_lblSviDugovi);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 2;
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 1;
		panel_1.add(list_1, gbc_list_1);
		
		JList list_2 = new JList();
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.gridwidth = 3;
		gbc_list_2.insets = new Insets(0, 0, 5, 0);
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 2;
		gbc_list_2.gridy = 1;
		panel_1.add(list_2, gbc_list_2);
		
		JLabel label_1 = new JLabel("Ukupan dug:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 2;
		panel_1.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("{dug}");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 2;
		panel_1.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("Naziv uplate:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel_1.add(label_3, gbc_label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel_1.add(textField_2, gbc_textField_2);
		
		JLabel label_4 = new JLabel("Vrijednost:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panel_1.add(label_4, gbc_label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		panel_1.add(textField_3, gbc_textField_3);
		
		JButton button = new JButton("Uplati");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.gridwidth = 4;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 5;
		panel_1.add(button, gbc_button);
		
		JButton button_1 = new JButton("Printaj potvrdu");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.gridwidth = 4;
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 6;
		panel_1.add(button_1, gbc_button_1);
		
		JLabel lblUkupanDugStudenta = new JLabel("Ukupan dug studenta:");
		GridBagConstraints gbc_lblUkupanDugStudenta = new GridBagConstraints();
		gbc_lblUkupanDugStudenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblUkupanDugStudenta.gridx = 0;
		gbc_lblUkupanDugStudenta.gridy = 3;
		frmUplate.getContentPane().add(lblUkupanDugStudenta, gbc_lblUkupanDugStudenta);
		
		JLabel lbldug_1 = new JLabel("{dug}");
		GridBagConstraints gbc_lbldug_1 = new GridBagConstraints();
		gbc_lbldug_1.anchor = GridBagConstraints.WEST;
		gbc_lbldug_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldug_1.gridx = 1;
		gbc_lbldug_1.gridy = 3;
		frmUplate.getContentPane().add(lbldug_1, gbc_lbldug_1);
		
		JLabel lblRokZaOtplatu = new JLabel("Rok za otplatu:");
		GridBagConstraints gbc_lblRokZaOtplatu = new GridBagConstraints();
		gbc_lblRokZaOtplatu.anchor = GridBagConstraints.EAST;
		gbc_lblRokZaOtplatu.insets = new Insets(0, 0, 5, 5);
		gbc_lblRokZaOtplatu.gridx = 3;
		gbc_lblRokZaOtplatu.gridy = 3;
		frmUplate.getContentPane().add(lblRokZaOtplatu, gbc_lblRokZaOtplatu);
		
		JLabel lblrok = new JLabel("{rok}");
		GridBagConstraints gbc_lblrok = new GridBagConstraints();
		gbc_lblrok.anchor = GridBagConstraints.WEST;
		gbc_lblrok.insets = new Insets(0, 0, 5, 5);
		gbc_lblrok.gridx = 4;
		gbc_lblrok.gridy = 3;
		frmUplate.getContentPane().add(lblrok, gbc_lblrok);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		GridBagConstraints gbc_btnIzai = new GridBagConstraints();
		gbc_btnIzai.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzai.gridx = 6;
		gbc_btnIzai.gridy = 3;
		frmUplate.getContentPane().add(btnIzai, gbc_btnIzai);
	}

}
