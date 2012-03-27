package com.summitbid.coach

import java.util.Date;

abstract class BaseDomain {
	public static final long serialVersionUid = 1l;
	String uuid
	String name
	Date dateCreated
	Date lastUpdated
	
	def final static transientFields = ['lastUpdated', 'dateCreated']
	
	static mapping = {
		tablePerHierarchy false
	}
	
	static constraints = {
		uuid(nullable:true, size:36..72)
		name(nullable:true, size:1..255)
		dateCreated(nullable:true)
		lastUpdated(nullable:true)
	}
	
	transient def beforeInsert = {
		if(! this.uuid) {
			uuid = java.util.UUID.randomUUID().toString()
		}
	}
	
	transient def beforeUpdate = {
	}
		
	
	transient def beforeDelete = {
	}
	
	/**
	* Validates and saves the supplied domain object.
	* Issues are printed to standard out.
	* @author Ed Young
	*/
   def validateAndSave = { flushStatus ->
	   def savedObj
	   def valid = this.validate()
	   
	   if (valid) {
		   savedObj = this.save(flush:flushStatus)
	   }
	   
	   if(!valid || !savedObj) {
		   log.error("Error saving " + this)
		   log.error this.errors
	   }
	   
	   savedObj
   }
   
   
   /**
	* Default validateAndSave method without Boolean flash status
	* @return : Boolean
	*
	* @author subrata
	*/
   def validateAndSave() {
	   this.validateAndSave(true)
   }

}
