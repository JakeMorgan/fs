<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import= com.accenture.be.entity.User%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FlowerShop</title>
</head>
<body>
<div style="text-align: center">
<h2>FlowerShop</h2>
<% User user = (User) session.getAttribute("user");%>
<b><p>Login: <input type="text" size="40" value= <%=user.getLogin() %></p></b>
<b><p>Address: <input type="text" size="40" value= <%=user.getAddress() %></p></b>
<b><p>Phone: <input type="text" size="40" value= <%=user.getPhone() %></p></b>
<b><p>Money: <%=user.getBalance() %></p></b>
<button type="submit" name="flowers">Flowers</button>
</div>
</body>
</html>