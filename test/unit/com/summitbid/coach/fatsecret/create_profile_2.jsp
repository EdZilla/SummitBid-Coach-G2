<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import="fatsecret.platform.*" %>
<%
FatSecretAPI api = new FatSecretAPI(getServletContext().getInitParameter("API_KEY"), getServletContext().getInitParameter("API_SECRET"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Example 2 - Create a new profile with user_id 'test@example.com'</title>
    </head>
    <body>
		<h1>Example 2</h1>
		<div>
			<b>Create a new profile with user_id 'test@example.com' using ProfileCreate</b>
		</div>
		<%
			try{
				FatSecretAuth auth = api.ProfileCreate("test@example.com");
				out.println("<div>Success</div>");
			}
			catch(FatSecretException ex)
			{
				out.println("<div>Error: " + ex.getCode() + " - " + ex.getMessage() + "</div>");
			}
		%>
		<br />
		<div>
			<b>Get the auth details for profile with user_id 'test@example.com' using ProfileGetAuth</b>
		</div>
		<%
			try{
				FatSecretAuth auth = api.ProfileGetAuth("test@example.com");
				out.println("<div>auth_token: " + auth.getToken() + "</div>");
				out.println("<div>auth_secret: " + auth.getSecret() + "</div>");
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