/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2client;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author studente
 */
public class ActionFrame extends JFrame implements Observer{
    private QuoteTableModel quoteTableModel = new QuoteTableModel();
    private JTable table = new JTable(quoteTableModel);
    
    // pulsanti
    private JButton shopBtn = new JButton("Shop");
    private JButton authenticateBtn = new JButton("Authenticate");

    // pannelli interni
    private JScrollPane jSPane = new JScrollPane(table);
    private JPanel centralPnl = new JPanel();
    private JPanel southPnl = new JPanel();

    private MyActionListener listener = new MyActionListener(this);

    public ActionFrame() {
        super("Actions system");
        
        this.enableShopButton(false);
        
        this.shopBtn.addActionListener(listener);
        this.shopBtn.setActionCommand(MyActionListener.SHOP_CMD);
        this.authenticateBtn.addActionListener(listener);
        this.authenticateBtn.setActionCommand(MyActionListener.AUTHENTICATE_CMD);
        
        this.centralPnl.add(jSPane);
        this.southPnl.add(shopBtn);
        this.southPnl.add(authenticateBtn);
        
        this.getContentPane().add(centralPnl, BorderLayout.CENTER);
        this.getContentPane().add(southPnl, BorderLayout.SOUTH);
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
                
    }
    
    public String getSelectedActionTitle(){
        int row = this.table.getSelectedRow();
        String selectedActionTitle = null;
        if (row>=0){
            selectedActionTitle = (String) this.table.getModel().getValueAt(row, 0);
        }
        return selectedActionTitle;
    }

    @Override
    public void update(Observable o, Object o1) {
        this.table.updateUI();
    }

    public void enableShopButton(boolean b) {
        this.shopBtn.setEnabled(b);
    }

    public QuoteTableModel getQuotesTableModel() {
        return this.quoteTableModel;
    }
    
}
