package com.summitbid.coach

class Food {

	String name
	String description
    static constraints = {
		name(nullable:false)
		description(nullable:true)
    }
}
