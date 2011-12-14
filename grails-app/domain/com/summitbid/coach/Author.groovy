package com.summitbid.coach

class Author {
	
	String name
	static hasMany = [ books: Book ]

    static constraints = {
		
    }
}
