package com.mycompany.lab2client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;


class ShopListener implements FocusListener, ActionListener{
    private ShopFrame frame;
    private ShopJMSManager shopManager;
    
    ShopListener(ShopFrame shopFrame) {
        this.frame = shopFrame;
        this.shopManager = new ShopJMSManager(shopFrame);
    }

    @Override
    public void focusGained(FocusEvent fe) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        try {
            String quantityTxt = this.frame.getQuantity();
            String priceTxt = this.frame.getPrice();

            int quantity = Integer.parseInt(quantityTxt);
            float price = Float.parseFloat(priceTxt);

            String res = String.format("%1$.2f", quantity * price);
            this.frame.setImportComplexValueLbl(res);
        } catch (NumberFormatException err) {
                this.frame.setImportComplexValueLbl("0.00");
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean goodEnd = false;
        try {
                goodEnd = this.shopManager.shop(
                                this.frame.getTitle(),
                                Float.parseFloat(this.frame.getPrice()),
                                Integer.parseInt(this.frame.getQuantity())
                        );
                JOptionPane.showMessageDialog(null, goodEnd, "InfoBox: " + "ShopFrame", JOptionPane.INFORMATION_MESSAGE);
        
                if (!goodEnd) {
                        this.frame.errorNotifier(
                                        "La transazione non \u00e8 andata a buon fine."
                                );
                }
        } catch (NumberFormatException nFE) {
                this.frame.errorNotifier(
                                "Quantit\u00e0 e prezzo devono essere valori numerici, " +
                                "risp. intero e decimale"
                        );
        }
    }

    
}
