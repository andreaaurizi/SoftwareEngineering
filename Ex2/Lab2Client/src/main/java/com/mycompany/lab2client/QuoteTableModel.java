package com.mycompany.lab2client;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

class QuoteTableModel extends AbstractTableModel implements Observer{

    private Vector<Quote> list = new Vector<Quote>();
    private String[] cols = {"Action title", "Quote", "Update date"};
    
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Quote elem = (Quote) list.get(rowIndex);
        switch(colIndex){
            case 0:
                return elem.title;
            case 1:
                return elem.quote;
            case 2:
                return elem.date;
        }
        return "";
    }
    
    public synchronized String getColumnName(int n){
        return cols[n];
    }
    
    private synchronized void updateTable(String title, float quote) {
        Quote q = new Quote();
        q.title = title;
        int i = list.indexOf(q);
        if(i<0){
            q.quote = quote;
            list.add(q);
        } else {
            q = (Quote) list.get(i);
            q.quote =  quote;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Quote q = (Quote) arg;
        this.updateTable(q.title, q.quote);
    }
}
