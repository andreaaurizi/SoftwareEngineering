package com.andreaaurizi.softwareengineering.jmsclient;

import java.util.Date;

public class Quote implements Comparable<Quote>{
	
	public String name;
	public float value;
	public Date date = new Date();
	
	public Quote() {}
	
	public Quote(String name, float quote) {
		this.name = name;
		this.value = quote;
	}
	
	@Override
	public int compareTo(Quote q) {
		return (((Quote) q).name.compareTo(this.name)); 
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Quote))
			return (false);
		else 
			return (((Quote) o).name.equals(this.name));
	}
	
}
