package Dodaci;

import Entiteti.Osoba; 

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Komponenta extends JPanel {
	private JLabel ind;
	private JLabel naz;
	private JLabel dugZaSk;
	private JLabel dugZaLi;
	
	private Osoba osoba;

	private int index;
	private String naziv;
	private double dugZaSkolarinu;
	private double dugZaLiteraturu;
	

	public Komponenta(int index, String naziv, double dugZaSkolarinu,
			double dugZaLiteraturu) {
		super();
		this.index = index;
		this.naziv = naziv;
		this.dugZaSkolarinu = dugZaSkolarinu;
		this.dugZaLiteraturu = dugZaLiteraturu;		
		super.setSize(588, 20);
		inicijaliziraj();
	}

	private void inicijaliziraj() {
		
		ind = new JLabel(String.valueOf(index));
		ind.setSize(this.getWidth()/4, this.getHeight());
		this.add(ind);
		
		naz = new JLabel(String.valueOf(naziv));
		naz.setSize(this.getWidth()/4, this.getHeight());
		this.add(naz);
		
		dugZaSk = new JLabel(String.valueOf(dugZaSkolarinu));
		dugZaSk.setSize(this.getWidth()/4, this.getHeight());
		this.add(dugZaSk);
		
		dugZaLi = new JLabel(String.valueOf(dugZaLiteraturu));
		dugZaLi.setSize(this.getWidth()/4, this.getHeight());
		this.add(dugZaLi);
			
		
	}




}
