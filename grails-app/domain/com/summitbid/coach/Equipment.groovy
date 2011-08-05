package com.summitbid.coach

class Equipment {
	String name
	String description
	
    static constraints = {
		name(nullable:false)
		description(nullable:false)
    }
}
