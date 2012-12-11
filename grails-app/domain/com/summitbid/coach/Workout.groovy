package com.summitbid.coach

/**
 * A workout is a set of exercises performed during a time period. 
 * 
 * @author eyoung2297k
 *
 */
class Workout extends BaseDomain{
	
	//String name
	String description
	//Date date	

	//static hasMany = [ exercises : Activity ]
	static hasMany = [ exercises : Exercise ]
	
    static constraints = {
		name(nullable:false)
		description(blank: true, nullable:true)
    }
	
	String toString() {
		"Workout: ${this.name} \n" +
		"description: ${this.description} \n"
	}
}
