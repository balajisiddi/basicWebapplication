<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>printed the time in the console</h4>
<%
    out.println(request.getAttribute("msg"));
	out.println(session.getAttribute("msg"));
%>
</body>
</html>