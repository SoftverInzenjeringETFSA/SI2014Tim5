package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Panel;

import javax.swing.JList;

import java.awt.Choice;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;

import java.awt.Color;




import Entiteti.Osoba;
import Dodaci.Komponenta;

import java.awt.ScrollPane;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.List;

import javax.swing.JScrollPane;


public class MainWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDo = new JLabel("Dobar dan, ");
		lblDo.setBounds(10, 11, 104, 14);
		frame.getContentPane().add(lblDo);
		
		JButton btnDeaktiviraj = new JButton("Deaktiviraj");
		btnDeaktiviraj.setBounds(513, 7, 89, 23);
		frame.getContentPane().add(btnDeaktiviraj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 592, 279);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", "", null},
				{null, null, "", null, null},
			},
			new String[] {
				"ID", "Ime i Prezime", "Indeks", "Dug za \u0161koralinu", "Dug za literaturu"
			}
		));
	}
}
