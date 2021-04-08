package com.andreaaurizi.softwareengineering.jmsclient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class ShopListener implements FocusListener, ActionListener{
	private ShopFrame frame;
	private ShopJMSManager shopMan;
	
	public ShopListener(ShopFrame shopFrame) {
		this.frame = shopFrame;
		this.shopMan = new ShopJMSManager(shopFrame);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean goodend = false;
		
		try {
			goodend = this.shopMan.shop(
					this.frame.getName(),
					Float.parseFloat(this.frame.getPrice()),
					Integer.parseInt(this.frame.getQuantity())
					);
			if(!(goodend)) {
				this.frame.notifierError("Transaction has no good end.");
			}
			
		} catch (NumberFormatException nFE) {
			this.frame.notifierError(
					"Quantity and price has to be numeric value, " +
					"risp. integer and decimal"
				);
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		/* DEVE RIMANERE VUOTO */		
	}

	@Override
	public void focusLost(FocusEvent e) {
		try {
			String quantityTxt = this.frame.getQuantity();
			String priceTxt = this.frame.getPrice();
			
			int quantity = Integer.parseInt(quantityTxt);
			float price = Float.parseFloat(priceTxt);
			
			// formatta il numero in modo tale che compaiano due cifre decimali
			String finals = String.format("%1$.2f", quantity * price);
			
			this.frame.setImportComplex(finals);
		} catch (NumberFormatException err) {
			this.frame.setImportComplex("0.00");
		}
	}

}
