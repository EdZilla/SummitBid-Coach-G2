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
	//def baseUri = 'http://platform.fatsecret.com/rest/server.api';
	def baseUri = "http" + URLEncoder.encode("://") + "platform.fatsecret.com" + URLEncoder.encode("/") + "rest" + URLEncoder.encode("/") + "server.api" + URLEncoder.encode("?")


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
		def signatureBaseString = createSignatureBaseString()
		println "sig base: ${signatureBaseString}"


		//		try {
		//			def response = client.get( path: "rest/server.api" )
		//			println "uri: ${client.getUri()}"
		//		} catch(groovyx.net.http.HttpResponseException ex)
		//		{
		//			println "ex: ${ex}"
		//			def resp = ex.getResponse()
		//			def data = resp.getData()
		//			println "data: " + data
		//			def header = resp.getAllHeaders()
		//			println "header: " + header
		//			def status = resp.getStatus()
		//			println "status: " + status
		//		}

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
		def commands = [
			"${oauth_consumer_key_tuple}",
			"${method_tuple}",
			"${oauth_nonce_tuple}",
			"${oauth_signature_method_tuple}",
			"${oauth_timestamp_tuple}",
			"${oauth_version_tuple}"
		]
		
		
		def qMap = [
			"oauth_timestamp":timeStamp,
			"oauth_consumer_key":oauth_consumer_key,
			"oauth_version":oauth_version,
			"oauth_signature_method":oauth_signature_method,
			"method":"exercises.get",
			"oauth_nonce":"${myRand}-${timeStamp}"
			]
		
		def orderedMap = qMap.sort()
		println "orderedMap: ${orderedMap}"
		def qs = new QueryString(orderedMap)
		println "qs: " + qs

		//println "base: ${base}"
		def base = "${HTTP_GET}&${baseUri}${qs}"
		//println "base: ${base}"

		return base
	}

	/**
	 * From Groovy Recipes
	 * 
	 *
	 */
	class QueryString{
		Map params = [:]
		//this constructor allows you to pass in a Map
		QueryString(Map params){
			if(params){
				this.params.putAll(params)
			}
		}
		//this method allows you to add name/value pairs
		void add(String name, Object value){
			params.put(name, value)
		}
		//this method returns a well-formed QueryString
		String toString(){
			def list = []
			params.each{name,value->
				list << "$name"  + URLEncoder.encode("=") + URLEncoder.encode(value.toString())
			}
			//return list.join("&" )
			return list.join( URLEncoder.encode('&'))
		}
	}
}
