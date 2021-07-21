package it.leonardocapozzi.softeng.RESTfebbraio2021;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import it.leonardocapozzi.softeng.SOAPfebbraio2021.DetailsImpl;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceLocator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ServiceException, RemoteException
    {
        WarehousewsService service = 
        		new WarehousewsServiceImplServiceLocator().getWarehousewsServiceImplPort();
        
        DetailsImpl obj = service.getDetails(1);
        System.out.println("book id: " + obj.getBookId() +
        		" book price: " + obj.getPrice());
        
        SellerMapEntry[] sellerMapEntry = obj.getSellerMap();
        
        
        for(int i = 0; i < sellerMapEntry.length; i ++) {
        	System.out.println("seller name: " + sellerMapEntry[i].getSeller().getName() +
        			" seller delivery date: " + sellerMapEntry[i].getDeliveryDate());
        }
    }
}
