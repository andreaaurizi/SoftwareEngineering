package com.andreaaurizi.softwareengineering.jmsclient;
import java.awt.event.*;
import java.util.Observer;

import javax.swing.*;

public class MyActionListener implements ActionListener{
	private ActionFrame actionFrame;
	public static final String BUY_CMD = "A";
	public static final String AUTHENTICATE_CMD = "B";
	
	private ActionJMSListener jmsListener;
	
	public MyActionListener(ActionFrame actionframe) {
		this.actionFrame = actionframe;
		this.jmsListener = new ActionJMSListener(
				new Observer[] {
						actionFrame,
						actionFrame.getQuoteTableModel()
				}
		);
	} 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == BUY_CMD) {
			buy();
		} else if (cmd == AUTHENTICATE_CMD) {
			authenticate();
		}
		
	}


	private void authenticate() {
		String user = User.getInstance().getUser();
		
		do {
			user = (String) JOptionPane.showInputDialog(
											this.actionFrame,
											"Write sender name",
											this.actionFrame.getTitle(),
											JOptionPane.PLAIN_MESSAGE,
											null,
											null,
											user
										);
			user.trim();
		} while (user!= null && user.equals(""));
		
		if (user != null) {
			this.actionFrame.enableBuyButton(true);
			this.jmsListener.start();
		}
		else
			this.jmsListener.stop();
		
		User.getInstance().setUser(user);
	}



	private void buy() {
		ShopFrame shoppingFrame = new ShopFrame();
		
		String nameAction = this.actionFrame.getSelectedActionName();
		
		if (nameAction != null) {
			/*
			 * Se viene selezionata una riga della tabella, allora nella finestra
			 * CopraFrame viene aggiornato il campo nomeTxt con il valore sezionato
			 */
			shoppingFrame.setName(nameAction);
		}
		shoppingFrame.setVisible(true);
	}
}
