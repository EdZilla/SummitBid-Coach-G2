package com.summitbid.coach

/**
 * fake controller for fake Author domain to test spock, geb, etc
 * @author eyoung2297k
 *
 */
class AuthorController {

    def scaffold = true
	
	def text = {
		render "text"
	}
	
	def someRedirect = { redirect(action: "someRedirect") }
	
	def bodyElementText = { render request.'XML'.body.text() }
	
	def model = { [a: '1'] }
}
