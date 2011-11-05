package com.summitbid.coach



import grails.test.mixin.*
import org.junit.*
import java.util.Random


import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import net.sf.json.JSON
//import spock.lang.Specification
//import spock.lang.Ignore

/**
 * See the API for {@link grails.test.mixin.domain.DomainUnitTestMixin} for usage instructions
 */
@TestFor(Exercise)
class ExerciseTests {
	def client;
	def baseUri = 'http://platform.fatsecret.com/rest/server.api';
	
	static final String  oauth_consumer_key = "006ffa526d1542ef88cbc79733770fe3"
	static final String  oauth_version = "1.0"
	static final String  oauth_signature_method = "HMAC-SHA1"
	static final String  HTTP_GET = "GET"
	static final String  HTTP_POST = "POST"
	
	def oauth_signiture = ""
	def oauth_timestamp
	def oauth_nonce = ""

	/**
	 * http://platform.fatsecret.com/api/Default.aspx?screen=rapiref&method=exercises.get
	 * <HTTP Method>&<Request URL>&<Normalized Parameters>
	 * 
	 * 
	 */
    void testExercisesGet() {
		
		client = new RESTClient(baseUri)
		def baseString = createSignatureBaseString()
		println baseUri + baseString;
		def uri = baseUri + baseString;
		try {
			//def response = client.get( path: baseString )
			def response = client.get( path: baseString )
			println "uri: ${client.getUri()}"
		} catch(groovyx.net.http.HttpResponseException ex)
		{
			println "ex: ${ex}"
			def resp = ex.getResponse()
			def data = resp.getData()
			println "data: " + data
			def header = resp.getAllHeaders()
			println "header: " + header
			def status = resp.getStatus()
			println "status: " + status
		} 

    }
	
	
	
	/**
	 * Step 1. Creating a Signature Base String
	 * <HTTP Method>&<Request URL>&<Normalized Parameters>

	 */
	String createSignatureBaseString()
	{
		Random rand = new Random()
		int max = 10000
		def myRand = rand.nextInt(max+1)
		
		def methods
		def requestUri
		def normalizedParams
		def timeStamp = new Date().getTime()
		def oauth_timestamp_tuple = "oauth_timestamp=${timeStamp}"
		def oauth_consumer_key_tuple = "oauth_consumer_key=${oauth_consumer_key}"
		def oauth_version_tuple = "oauth_version=${oauth_version}"
		def oauth_signature_method_tuple = "oauth_signature_method=${oauth_signature_method}"
		def method_tuple = "method=exercises.get"
		def oauth_nonce_tuple = "oauth_nonce=${myRand}-${timeStamp}"
		def random
		

		println "myRand: ${myRand}"
//		def randomIntegerList = []
//		(1..10).each {
//			randomIntegerList << rand.nextInt(max+1)
//		}
		
		//def base = "?oauth_consumer_key=006ffa526d1542ef88cbc79733770fe3&oauth_version=1.0&method=exercises.get&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1320493708969&oauth_nonce=9507-1320493708969&oauth_signature=GET%26http%3A%2F%2Fplatform.fatsecret.com%2Frest%2Fserver.api%26006ffa526d1542ef88cbc79733770fe3HMAC-SHA113204937089699507-13204937089691.0"
		def base = "?${method_tuple}&${oauth_consumer_key_tuple}&${oauth_nonce_tuple}&${oauth_signature_method_tuple}&${oauth_timestamp_tuple}&${oauth_version_tuple}"
		return base
	}
}
