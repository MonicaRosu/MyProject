<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post">

Ti-ai uitat parola ?


<br>
<br>

		Username: <input type="text" name="username" > <br/> 
		<br>
		Parola noua :<input type="password" name="password"> <br/> 
		<br>
		Confirma Parola :<input type="password" name="passwordR"> <br/> 
		
		<br>
		<input type="submit" value="Inregistreaza">
	</form>

<%@include file="navigation.jsp" %>


</body>
</html>