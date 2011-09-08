package com.summitbid.coach

class Meal {
	String name
	String description
	
	static hasMany = [ foods : Food ]
    
	static constraints = {
		name(nullable:false)
		description(nullable:true)
    }
	
	String toString()
	{
		return "food: ${name}, ${description}"
	}
}
