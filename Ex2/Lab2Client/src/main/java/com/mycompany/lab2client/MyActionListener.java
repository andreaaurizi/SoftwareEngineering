
package com.mycompany.lab2client;

import java.awt.event.*;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author studente
 */
class MyActionListener implements ActionListener{
    public static final String SHOP_CMD = "shop";
    public static final String AUTHENTICATE_CMD = "authenticate";
    private ActionFrame actionFrame;
    
    private ActionJMSListener jmsListener;
    public MyActionListener(ActionFrame frame) {
        this.actionFrame = frame;
        
        this.jmsListener = new ActionJMSListener(
                            new Observer[] {
                                            actionFrame,
                                            actionFrame.getQuotesTableModel()
                            }
        );
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd == SHOP_CMD)
            shop();
        else if(cmd == AUTHENTICATE_CMD)
            authenticate();
    }
    
    private void authenticate() {
        String user = User.getInstance().getUser();
        
        do{
            user = (String) JOptionPane
					.showInputDialog(
							this.actionFrame,
							"Who are you?",
							this.actionFrame.getTitle(),
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							user
					);
            user.trim();
        }while(user != null && user == "");
        
        if (user != null){
            this.actionFrame.enableShopButton(true);
            this.jmsListener.start();
        }
        else 
            this.jmsListener.stop();
        
        User.getInstance().setUser(user);
    }

    private void shop() {
        ShopFrame shopFrame = new ShopFrame();
        String actionTitle = this.actionFrame.getSelectedActionTitle();
        
        if(actionTitle != null){
            shopFrame.setTitle(actionTitle);
        }
        shopFrame.setVisible(true);
    }

    
}
