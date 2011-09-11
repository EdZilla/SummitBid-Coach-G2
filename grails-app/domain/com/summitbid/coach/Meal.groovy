package com.summitbid.coach

import java.util.Date;

class Meal {
	String name
	String description
	Date date;
	Float cost;
	
	static hasMany = [ foods : Food ]
    
	static constraints = {
		name(nullable:false)
		description(nullable:true)
		cost(nullable:true)
    }
	
	
	String toString(){"Meal \n" +
		" name: ${this.name}, \n" +
		" date: ${this.date}, \n" +
		" desc: ${this.description}"}
}
