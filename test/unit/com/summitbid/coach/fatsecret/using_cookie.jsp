<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="fatsecret.platform.*" %>
<%
	FatSecretAPI api = new FatSecretAPI(getServletContext().getInitParameter("API_KEY"), getServletContext().getInitParameter("API_SECRET"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Example 3 - Setting up a session cookie</title>
    </head>
    <body>
		<h1>Example 3</h1>
		<div>
			<b>Create a new session using ProfileRequestScriptSessionKey and set cookie</b>
		</div>
		<%
			try{
				String sessionKey = api.ProfileRequestScriptSessionKey("test@example.com", 0, -1, null, true);
				Cookie cookie = new Cookie("fatsecret_session_key", sessionKey);
				cookie.setPath("/");
				
				response.addCookie(cookie);

				out.println("<div>session_key: " + sessionKey + "</div><br />");
				out.println("<div style=\"width:500px\"><script src=\"" + getServletContext().getInitParameter("API_URL") + "key=" + getServletContext().getInitParameter("API_KEY") + "&auto_load=true\"></script></div>");
			}
			catch(FatSecretException ex)
			{
				out.println("<div>Error: " + ex.getCode() + " - " + ex.getMessage() + "</div>");
			}
		 %>
		<br />
		<a href="../index.html">Back</a>
    </body>
</html>