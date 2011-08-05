package com.summitbid.coach

abstract class Activity {
	String name
	String description
    
	static constraints = {
		name(nullable:false)
		description(nullable:true)
    }
}
