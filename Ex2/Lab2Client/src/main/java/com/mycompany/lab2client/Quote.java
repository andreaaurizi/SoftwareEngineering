package com.mycompany.lab2client;

import java.util.Date;
class Quote implements Comparable<Quote>{

    public String title;
    public float quote;
    public Date date = new Date();
    
    public Quote(){}
    
    public Quote (String title, float quote){
        this.title = title;
        this.quote = quote;
    }
    
    public boolean equals(Object o){
        if (!(o instanceof Quote))
            return false;
        else 
            return (((Quote) o).title.equals(this.title));
    }
    
    @Override
    public int compareTo(Quote t) {
        return (((Quote) t).title.compareTo(this.title));
    }
    
}
