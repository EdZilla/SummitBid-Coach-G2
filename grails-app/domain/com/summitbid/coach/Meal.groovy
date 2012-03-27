package com.summitbid.coach

import java.util.Date;

class Meal extends BaseDomain {
	//String name
	Date date;
	String description
	Float cost;
	
	static hasMany = [ foods : Food ]
    
	static constraints = {
		name(nullable:false)
		date(nullable:false)
		description(nullable:true)
		cost(nullable:true)
    }
	
	
	String toString(){"Meal \n" +
		" name: ${this.name}, \n" +
		" date: ${this.date}, \n" +
		" desc: ${this.description}"}
}
