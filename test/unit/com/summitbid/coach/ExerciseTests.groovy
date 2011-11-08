package com.summitbid.coach



import grails.test.mixin.*
import org.junit.*

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Random


import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import net.sf.json.JSON
//import spock.lang.Specification

import javax.crypto.Mac;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.HmacSHA1;
import org.apache.commons.codec.binary.Base64

//import spock.lang.Ignore

/**
 * See the API for {@link grails.test.mixin.domain.DomainUnitTestMixin} for usage instructions
 */
@TestFor(Exercise)
class ExerciseTests {
	def client;
	//def baseUri = 'http://platform.fatsecret.com/rest/server.api';
	def baseUri = "http://platform.fatsecret.com/rest/server.api?"

	static final String  oauth_consumer_key = "006ffa526d1542ef88cbc79733770fe3"
	static final String  oauth_version = "1.0"
	static final String  oauth_signature_method = "HMAC-SHA1"
	static final String  HTTP_GET = "GET"
	static final String  HTTP_POST = "POST"
	
	def signatureBaseString
	def oauth_signiture = ""
	def oauth_timestamp
	def oauth_nonce = ""
	def timeStamp = new Date().getTime()
	
	Random rand = new Random()
	int max = 10000
	def myRand = rand.nextInt(max+1)
	
	// parameter map
	def qMap = [
		"oauth_timestamp":timeStamp,
		"oauth_consumer_key":oauth_consumer_key,
		"oauth_version":oauth_version,
		"oauth_signature_method":oauth_signature_method,
		"method":"exercises.get",
		"oauth_nonce":"${myRand}-${timeStamp}"
		]

	/**
	 * http://platform.fatsecret.com/api/Default.aspx?screen=rapiref&method=exercises.get
	 * <HTTP Method>&<Request URL>&<Normalized Parameters>
	 * 
	 * 
	 */
	void testExercisesGet() {

		client = new RESTClient(baseUri)
		signatureBaseString = createSignatureBaseString()
		
		println "sig base: ${signatureBaseString}"
		signatureBaseString = URLEncoder.encode(signatureBaseString)
		println "sig base: ${signatureBaseString}"
		
		def sigValue = calculateSigValue(signatureBaseString, ("${oauth_consumer_key}" + '&'))
		println "sigValue: ${sigValue}"

		def request = "${constructRequest(qMap,sigValue)}"
		println "request: ${request}"
		
				try {
					
					println "SENDING: ${request}"
					def response = client.get( path: request )
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
	 * 	Step 3. Sending the Request
	 * Send all the parameters used to generate the Signature Base String via the HTTP method specified 
	 * in the Signature Base String, with the inclusion of the oauth_signature.
	 * @param qMap
	 * @param oauth_signature
	 * @return
	 */
	String constructRequest(def qMap, String oauth_signature)
	{
		def path = "rest/server.api?"
		qMap.putAt("oauth_signature", oauth_signature)
		qMap = qMap.sort()
		def queryString = new QueryString(qMap).toString();
		println "queryString: ${queryString}"
		return "${path}${queryString}"
	}

	/**
	 * Step 2. Calculating the Signature value (oauth_signature)
	 * @return
	 */
	String calculateSigValue(String baseString, String key)
	{
		println "baseString: ${baseString}, key: ${key}"
		def result = "ERROR: Could not calculateSigValue"
		try {
			result = computeSignature(baseString, key)
			
		}catch(GeneralSecurityException ex)		{
			println "ERROR: ex: ${ex}"
		}catch(UnsupportedEncodingException ex)		{
			println "ERROR: ex: ${ex}"
		}
		return result
	}

	/**
	 * Step 1. Creating a Signature Base String
	 * <HTTP Method>&<Request URL>&<Normalized Parameters>
	 */
	String createSignatureBaseString()
	{


		def methods
		def requestUri
		def normalizedParams
		def timeStamp = new Date().getTime()
		def random
		
		
		
		
		def orderedMap = qMap.sort()
//		println "orderedMap: ${orderedMap}"
		def qs = new QueryString(orderedMap)
//		println "qs: " + qs

		def base = "${HTTP_GET}&${baseUri}${qs}"

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
				list << "$name=" + URLEncoder.encode(value.toString())
			}
			return list.join("&" )
		}
	}
	
	
	/**
	*
	* @param baseString
	* @param keyString
	* @return
	* @throws GeneralSecurityException
	* @throws UnsupportedEncodingException
	*/
	String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
	   
		   SecretKey secretKey = null;
	   
		   byte[] keyBytes = keyString.getBytes();
		   secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
	   
		   Mac mac = Mac.getInstance("HmacSHA1");
	   
		   mac.init(secretKey);
	   
		   byte[] text = baseString.getBytes();
	   
		   return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
	   }
	   
}
