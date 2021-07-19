package com.andreaaurizi.softwareengineering.jmsclient;
import java.text.DateFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class QuotesTableModel extends AbstractTableModel implements Observer{
	private Vector<Quote> lista = new Vector<Quote>();
	private String[] cols = { "Action Name", "Quote", "Data update"};
	
	private static final int COLS_N = 3;
	
	public synchronized int getColumnCount() {
		return COLS_N;
	}
	
	public synchronized int getRowCount() {
		return lista.size();
	}
	
	public synchronized Object getValueAt(int rowIndex, int columnIndex) {
		Quote quote = (Quote) lista.get(rowIndex);
		switch (columnIndex) {
		case 0 :
			return (quote.name);
		case 1 : 
			return (new Float(quote.value));
		case 2:
			DateFormat dateformat = DateFormat.getTimeInstance();
			return (dateformat.format(quote.date));
		}
		return ("");
 	}
	
	public synchronized String getColumnName(int n) {
		return (cols[n]);
	}
	
	public synchronized void updateQuote(String name, float quote) {
		Quote newquote = new Quote();
		newquote.name = name;
		int i = lista.indexOf(newquote);
		
		System.out.println("Upadate quote : " + i);
		System.out.println(name + " " + quote);
		
		if (i<0) {
			newquote.value = quote;
			lista.add(newquote);
		} else {
			newquote =(Quote) lista.get(i);
			newquote.value = quote;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Quote quote = (Quote) arg;
		this.updateQuote(quote.name, quote.value);
	}
}
