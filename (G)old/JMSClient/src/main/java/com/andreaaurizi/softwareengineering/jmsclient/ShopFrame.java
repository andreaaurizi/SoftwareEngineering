package com.andreaaurizi.softwareengineering.jmsclient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShopFrame extends JFrame implements Observer {

	/** Larghezza dei campi per le etichette */
	private static final int LABEL_WIDTH = 120;

	// etichette
	private JLabel userLbl = new JLabel("User:");
	private JLabel nameLbl = new JLabel("Name:");
	private JLabel priceLbl = new JLabel("Price:");
	private JLabel quantityLbl = new JLabel("Quantity:");
	private JLabel importComplexLbl = new JLabel("Import:");
	private JLabel euroPriceLbl = new JLabel("\u20ac");
	private JLabel euroImportLbl = new JLabel("\u20ac");

	// etichette aggiornabili
	private JLabel userTxtLbl = new JLabel();
	private JLabel importComplexValueLbl = new JLabel("0.00");

	// pannelli
	private JPanel userPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pricePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel quantityPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel importComplexPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));

	private JPanel centralPnl = new JPanel();
	private JPanel suothPnl = new JPanel();

	// widget di input
	private JTextField nameTxt = new JTextField(20);
	private JTextField priceTxt = new JTextField(10);
	private JTextField quantityTxt = new JTextField(5);

	// pulsanti
	private JButton orderBtn = new JButton("Order");

	// ascoltatori
	private ShopListener listener = new ShopListener(this);
	
	public ShopFrame() {
		super("Do Shopping");
		
		this.userTxtLbl.setText(User.getInstance().getUser());
		
		this.setTagGraphicsCharacteristics();
		
		// aggiunge i widget ai pannelli
		this.userPnl.add(userLbl);
		this.userPnl.add(userTxtLbl);
		this.namePnl.add(nameLbl);
		this.namePnl.add(nameTxt);
		this.pricePnl.add(priceLbl);
		this.pricePnl.add(priceTxt);
		this.pricePnl.add(euroPriceLbl);
		this.quantityPnl.add(quantityLbl);
		this.quantityPnl.add(quantityTxt);

		this.priceTxt.addFocusListener(listener);
		this.quantityTxt.addFocusListener(listener);
		this.orderBtn.addActionListener(listener);

		this.importComplexPnl.add(importComplexLbl);
		this.importComplexPnl.add(importComplexValueLbl);
		this.importComplexPnl.add(euroImportLbl);

		this.centralPnl.setLayout(new BoxLayout(centralPnl, BoxLayout.Y_AXIS));
		
		this.centralPnl.add(userPnl);
		this.centralPnl.add(namePnl);
		this.centralPnl.add(pricePnl);
		this.centralPnl.add(quantityPnl);
		this.centralPnl.add(importComplexPnl);

		this.suothPnl.add(orderBtn);

		this.getContentPane().add(centralPnl, BorderLayout.CENTER);
		this.getContentPane().add(suothPnl, BorderLayout.SOUTH);

		this.pack();
	}

	
	private void setTagGraphicsCharacteristics() {
		// usato solo in quanto la dimensione di default per le etichette prevede
		// l'inserimento sia della larghezza, che ci interessa, sia dell'altezza
		int labelHeight = this.userLbl.getPreferredSize().height;

		this.userLbl
				.setPreferredSize(new Dimension(LABEL_WIDTH, labelHeight));
		this.nameLbl
				.setPreferredSize(new Dimension(LABEL_WIDTH, labelHeight));
		this.priceLbl
				.setPreferredSize(new Dimension(LABEL_WIDTH, labelHeight));
		this.quantityLbl
				.setPreferredSize(new Dimension(LABEL_WIDTH, labelHeight));
		this.importComplexLbl
				.setPreferredSize(new Dimension(LABEL_WIDTH, labelHeight));
		
		this.userLbl
				.setHorizontalAlignment(JLabel.RIGHT);
		this.nameLbl
				.setHorizontalAlignment(JLabel.RIGHT);
		this.priceLbl
				.setHorizontalAlignment(JLabel.RIGHT);
		this.quantityLbl
				.setHorizontalAlignment(JLabel.RIGHT);
		this.importComplexLbl
				.setHorizontalAlignment(JLabel.RIGHT);
		
	}
	
	public void notifierError(String error) {
		JOptionPane.showMessageDialog(this, error, this.getTitle(), JOptionPane.ERROR_MESSAGE);
	}
	
	// methods for field access
	public String getQuantity() {
		return this.quantityTxt.getText();
	}
	
	public String getPrice() {
		return this.priceTxt.getText();
	}
	
	public String getName() {
		return this.nameTxt.getText();
	}
	
	public void setName(String name) {
		this.nameTxt.setText(name);
	}
	
	public void setImportComplex(String complexImport) {
		this.importComplexValueLbl.setText(complexImport);
	}

	@Override
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(
				this,
				arg.toString(),
				this.getTitle(),
				JOptionPane.INFORMATION_MESSAGE);
		
	}

}
