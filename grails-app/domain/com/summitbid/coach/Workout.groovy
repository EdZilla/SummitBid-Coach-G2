package com.summitbid.coach

class Workout {
	
	String name
	String description
	Date date
	
	static hasMany = [ exercises : Activity ]
    static constraints = {
    }
}
