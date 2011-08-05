package com.summitbid.coach

class Workout {
	
	String name
	String description
	
	static hasMany = [ exercises : Activity ]
    static constraints = {
    }
}
