<%@ page import="shishir.purdue.edu.myServlet" %>
<% 
String zipCode = request.getParameter("fname");
String country = request.getParameter("lname");
int iRowAffected = 0;   

myServlet my = new myServlet();
String weather = my.getWeather(zipCode, country);
double temp = Double.parseDouble(weather);
temp = temp - 273.00;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weather Finder</title>
</head>
<body>
<p>Temperature: <%=temp%></p>
<a href="index.jsp">Go Back</a>
</body>
</html>
