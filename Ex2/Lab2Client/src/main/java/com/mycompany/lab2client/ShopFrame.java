package com.mycompany.lab2client;

import java.awt.BorderLayout;
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

public class ShopFrame extends JFrame implements Observer{
    /** Larghezza dei campi per le etichette */
    private static final int LABEL_WIDTH = 120;

    // etichette
    private JLabel userLbl = new JLabel("Uter:");
    private JLabel titleLbl = new JLabel("Title:");
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
    private JPanel titlePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pricePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel quantityPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel importComplexPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel centralPnl = new JPanel();
    private JPanel southPnl = new JPanel();

    // widget di input
    private JTextField titleTxt = new JTextField(20);
    private JTextField priceTxt = new JTextField(10);
    private JTextField quantityTxt = new JTextField(5);

    // pulsanti
    private JButton orderBtn = new JButton("Order");
    
    private ShopListener listener = new ShopListener(this);
    
    public ShopFrame () {
        super("Do shopping");
        this.userTxtLbl.setText(User.getInstance().getUser());
        
        this.userPnl.add(userLbl);
        this.userPnl.add(userTxtLbl);
        this.titlePnl.add(titleLbl);
        this.titlePnl.add(titleTxt);
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
        this.centralPnl.add(titlePnl);
        this.centralPnl.add(pricePnl);
        this.centralPnl.add(quantityPnl);
        this.centralPnl.add(importComplexPnl);

        this.southPnl.add(orderBtn);

        this.getContentPane().add(centralPnl, BorderLayout.CENTER);
        this.getContentPane().add(southPnl, BorderLayout.SOUTH);

        this.pack();
    }
    
    public void errorNotifier(String error){
        JOptionPane.showMessageDialog(this,
                                    error,
                                    this.getTitle(),
                                    JOptionPane.ERROR_MESSAGE);
    }
    

    @Override
    public void setTitle(String actionTitle) {
        this.titleTxt.setText(actionTitle);
    }

    public String getTitle() {
        return this.titleTxt.getText();
    }

    public String getPrice() {
        return this.priceTxt.getText();
    }

    public String getQuantity() {
        return this.quantityTxt.getText();
    }

    public void setImportComplexValueLbl(String importComplexValue) {
        this.importComplexValueLbl.setText(importComplexValue);
    }
    

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(this,
                                        arg.toString(),
                                        this.getTitle(),
                                        JOptionPane.INFORMATION_MESSAGE);
    }
}
