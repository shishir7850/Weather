<jsp:useBean id="sample" scope="page" class="com.home.file.sample" /> 

String zipcode = request.getParameter("fname");
String country = request.getParameter("lname");

sample.getWeather("zipcode", "country");