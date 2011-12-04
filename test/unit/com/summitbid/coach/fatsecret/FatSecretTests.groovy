package com.summitbid.coach.fatsecret;

import static org.junit.Assert.*;
import fatsecret.platform.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.crypto.Mac;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import com.sun.crypto.provider.HmacSHA1;

class FatSecretTests {

	/**
	 * 
	 */
	void testAPIProfileCreate() {
		FatSecretAPI api = new FatSecretAPI("006ffa526d1542ef88cbc79733770fe3", "907e02a0141147f4b3100fa83025efa9");
		assert api
		try {
			FatSecretAuth auth = api.ProfileCreate();
			assert auth
			println "token: ${auth.getToken()}"
			println "secret: ${auth.getSecret()}"
		} catch(FatSecretException ex) {
			println("error: " + ex.getCode() + " - " + ex.getMessage() );
		}
	}
	
	/**
	 * 
	 */
	void testAPIProfileCreate2() {
		
		FatSecretAPI api = new FatSecretAPI("006ffa526d1542ef88cbc79733770fe3", "907e02a0141147f4b3100fa83025efa9");
		
		try{
			println "create a profile"
			FatSecretAuth auth = api.ProfileCreate("test@exampleAlulu.com");
			println("Success");
		}
		catch(FatSecretException ex)
		{
			println("Error: " + ex.getCode() + " - " + ex.getMessage() + " end ");
		}
		
		try{
			println "get auth"
			FatSecretAuth auth = api.ProfileGetAuth("test@exampleAlulu.com");
			println("auth_token: " + auth.getToken() + " end");
			println("auth_secret: " + auth.getSecret() + " end");
		}
		catch(FatSecretException ex)
		{
			println("Error: " + ex.getCode() + " - " + ex.getMessage() + " end");
		}
		
		
	}
	
	/**
	 * 
	 */
	void testAPISetSession() {
		
		FatSecretAPI api = new FatSecretAPI("006ffa526d1542ef88cbc79733770fe3", "907e02a0141147f4b3100fa83025efa9");
		HttpServletResponse response;
		try{
			String sessionKey = api.ProfileRequestScriptSessionKey("test@example.com", 0, -1, null, true);
			Cookie cookie = new Cookie("fatsecret_session_key", sessionKey);
			cookie.setPath("/");
			
			//response.addCookie(cookie);

			println("session_key: " + sessionKey + " end ");
			//println("<div style=\"width:500px\"><script src=\"" + getServletContext().getInitParameter("API_URL") + "key=" + getServletContext().getInitParameter("API_KEY") + "&auto_load=true\"></script></div>");
		}
		catch(FatSecretException ex)
		{
			println("Error: " + ex.getCode() + " - " + ex.getMessage() + " end ");
		}
	}
	
	/**
	 * 
	 */
	void testAPIWithUrl() {
		
		FatSecretAPI api = new FatSecretAPI("006ffa526d1542ef88cbc79733770fe3", "907e02a0141147f4b3100fa83025efa9");
		
		try{
			String sessionKey = api.ProfileRequestScriptSessionKey("test@example.com", 0, -1, null, false);
			println("session_key: " + sessionKey + " end");
			//println("<div style=\"width:500px\"><script src=\"" + getServletContext().getInitParameter("API_URL") + "key=" + getServletContext().getInitParameter("API_KEY") + "&auto_load=true&fatsecret_session_key=" + sessionKey + "\"></script></div>");
		}
		catch(FatSecretException ex)
		{
			println("Error: " + ex.getCode() + " - " + ex.getMessage() + " end");
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
