package com.summitbid.coach

/**
 * A workout is a set of exercises performed during a time period. 
 * 
 * @author eyoung2297k
 *
 */
class Workout {
	
	String name
	String description
	//Date date
	
	static hasMany = [ exercises : Activity ]
	
    static constraints = {
		name(nullable:false)
		description(blank: true, nullable:true)
    }
}
