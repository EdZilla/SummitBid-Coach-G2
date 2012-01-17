package com.summitbid.coach

class Exercise extends Activity {
	

	@Override
	String toString()
	{
		return "Exercise: ${name}, ${description}"
	}
	
    static constraints = {
    }
}
