<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
 %>
<%@ page import ="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String dbUrl="jdbc:mysql://localhost:3306/servlet_one";
String dbUsername="root";
String dbPassword="1234";
Connection conn=null;
PreparedStatement pstatement = null;
String sql ="SELECT * FROM users";

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
pstatement=conn.prepareStatement(sql);
ResultSet rs = pstatement.executeQuery();
out.println("<table><thead><tr><th>First Name</th><th>Last Name</th></tr></thead>");
while(rs.next()){
	String fname= rs.getString("fname");
	String lname= rs.getString("lname");
	out.println("<tr><td>"+fname+"</td><td>"+lname+"</td></tr>");	
}
out.println("</table>");

%>

</body>
</html>