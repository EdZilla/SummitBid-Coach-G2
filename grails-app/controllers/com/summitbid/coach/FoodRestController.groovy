package com.summitbid.coach


import grails.converters.*
import com.summitbid.coach.Food

class FoodRestController {


		def list = { 
			
			log.trace "Executing action: '$actionName', params: '$params', request: '$request.method'"
			println "format:  " + request.getFormat()
			println "header:  " + request.getHeader("accept")
			withFormat {
				json { render Food.list() as JSON }
				xml { render Food.list() as XML }
				
			} 
		}
		def show = {
			log.trace "Executing action: '$actionName', params: '$params', request: '$request.method'"
			Food food = Food.get(params.id)
			render food as XML
		}
	

}
