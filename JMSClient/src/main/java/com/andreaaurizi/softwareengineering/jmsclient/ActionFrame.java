package com.andreaaurizi.softwareengineering.jmsclient;
import com.andreaaurizi.softwareengineering.jmsclient.QuotesTableModel;

import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;

public class ActionFrame extends JFrame implements Observer{
	private QuotesTableModel quotesTableModel = new QuotesTableModel();
	private JTable table = new JTable(quotesTableModel);
	
	// buttons
	private JButton buyBtn = new JButton("Buy");
	private JButton authenticateBtn = new JButton("Authenticate"); 
	
	// internal buttons
	private JScrollPane jSPane = new JScrollPane(table);
	private JPanel centralPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	
	private MyActionListener listener = new MyActionListener(this);
	
	public ActionFrame () {
		super("Actions system");
		
		this.enableBuyButton(false);
		
		//ActionListener on buttons
		this.buyBtn.addActionListener(listener);
		this.buyBtn.setActionCommand(MyActionListener.BUY_CMD);
		this.authenticateBtn.addActionListener(listener);
		this.authenticateBtn.setActionCommand(MyActionListener.AUTHENTICATE_CMD);
		
		//Set widget into panels
		this.centralPanel.add(jSPane);
		this.southPanel.add(buyBtn);
		this.southPanel.add(authenticateBtn);
		
		//set panel into the frame
		this.getContentPane().add(centralPanel, BorderLayout.CENTER);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void enableBuyButton(boolean enable) {
		this.buyBtn.setEnabled(enable);		
	}
	
	public String getSelectedActionName() {
		int row = this.table.getSelectedRow();
		String nameSelectedAction = null;
		if (row >= 0 ) {
			nameSelectedAction = (String) this.table.getModel().getValueAt(row, 0);
		}
		return nameSelectedAction;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.table.updateUI();		
	}
	
	public QuotesTableModel getQuoteTableModel() {
		return this.quotesTableModel;
	}
	
	public static void main(String[] args) {
		ActionFrame af = new ActionFrame();
	}
}
