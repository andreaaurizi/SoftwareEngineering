package it.leonardocapozzi.softeng.RESTfebbraio2021;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.rpc.ServiceException;

import it.leonardocapozzi.softeng.SOAPfebbraio2021.DetailsImpl;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.SellerMapEntry;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsService;
import it.leonardocapozzi.softeng.SOAPfebbraio2021.WarehousewsServiceImplServiceLocator;

@Path("/books")
public class BookRepository {
	private List<Book> books;
	
	/*
	 *  GET /books
	 	GET /books/{id}
	 	GET /books/{id}/sellers
	 	GET /books/{id}/sellers/{id}/delivery-date
	 */
	
	public BookRepository() {
		this.books = new ArrayList<>();
		
		Book book1 = new Book(1, "L'ombra del vento", "Carlos Ruiz Zafon", "2004");
		Book book2 = new Book(2, "Roma", "Alberto Angela", "2010");
		Book book3 = new Book(3, "Donne", "Bukowski", "2009");
		Book book4 = new Book(4, "Ricordati di guardare la luna", "Nicolas Sparks", "2009");
		Book book5 = new Book(5, "900", "Baricco", "2009");
		
		this.books.add(book1);
		this.books.add(book2);
		this.books.add(book3);
		this.books.add(book4);
		this.books.add(book5);
	}
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Book> getAllBooks() {
		return this.books;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Book getBookDetails(@PathParam("id") int id) throws ServiceException, RemoteException {
		return findBookById(id);
	}
	
	@GET
	@Path("/{id}/sellers")
	@Produces("application/json")
	public List<String> getSellers(@PathParam("id") int id) throws RemoteException, ServiceException {
		Book book = findBookById(id);
		BookDetails bookDetails = book.getBookDetails();
		List<String> list = new ArrayList<>(bookDetails.getSellerMap().keySet());		
		
		return list;
	}
	
	@GET
	@Path("/{id}/sellers/{idSeller}/delivery-date")
	@Produces("application/json")
	public String getDeliveryDate(@PathParam("id") int id, @PathParam("idSeller") String idSeller)
			throws RemoteException, ServiceException {
		String str = findBookById(id).getBookDetails().getSellerMap().get(idSeller);
		System.out.println("########" + str + "#########");
		return str;
	}
	
	private Book findBookById(int id) throws ServiceException, RemoteException {
		Book book = null;
		for(Book b : this.books) {
			if(b.getId() == id) {
				book = b; 
			}
		}
		
		if(book == null) return null;
		
		WarehousewsService service = 
        		new WarehousewsServiceImplServiceLocator().getWarehousewsServiceImplPort();
        
        DetailsImpl obj = service.getDetails(id);
        System.out.println("book id: " + obj.getBookId() +
        		" book price: " + obj.getPrice());
        
        SellerMapEntry[] sellerMapEntry = obj.getSellerMap();
        
        
        BookDetails bookDetails = new BookDetails();
        bookDetails.setPrice(obj.getPrice());
        bookDetails.setSellerMap(new HashMap<String, String>());
        
        for(int i = 0; i < sellerMapEntry.length; i ++) {
        	bookDetails.getSellerMap().put(sellerMapEntry[i].getSeller().getName(), sellerMapEntry[i].getDeliveryDate());
        	System.out.println("seller name: " + sellerMapEntry[i].getSeller().getName() +
        			" seller delivery date: " + sellerMapEntry[i].getDeliveryDate());
        }
        
        book.setBookDetails(bookDetails);
        
       
        return book;
	}
	
}
