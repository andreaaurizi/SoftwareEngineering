package it.leonardocapozzi.softeng.RESTfebbraio2021;

import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "bookdetails")
public class BookDetails {
	private double price;
	private Map<String, String> sellerMap;
	
	public BookDetails() {}
	
	public BookDetails(double price, Map<String, String> sellerMap) {
		super();
		this.price = price;
		this.sellerMap = sellerMap;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Map<String, String> getSellerMap() {
		return sellerMap;
	}

	public void setSellerMap(Map<String, String> sellerMap) {
		this.sellerMap = sellerMap;
	}

	@Override
	public String toString() {
		return "BookDetails [price=" + price + ", sellerMap=" + sellerMap + "]";
	}
	
	
	
	
	
}
