<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Shoaib
  Date: 14-May-20
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web Application Tutorial</title>
  </head>
  <body>

  <h2>Hello world!</h2>

  <%
    Date date = new Date();
    out.print(date);
  %>

  <p>Body text, this is my second web application JSP page.</p>


  </body>
</html>
