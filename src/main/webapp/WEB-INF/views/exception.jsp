<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
<h3>This is a JSP  exception page</h3>
 <p>Spring Handler method: ${handler}</p>
 <p>
  Status:(javax.servlet.error.status_code)<br/>
        <%=request.getAttribute("javax.servlet.error.status_code") %>
 </p>
  <p>
   Status:(response.getStatus())<br/><%=response.getStatus() %>
  </p>
 <p>
  Reason:<br/><%=request.getAttribute("javax.servlet.error.message") %>
 </p>
 <p>
  Type:<br/><%=request.getAttribute("javax.servlet.error.exception_type") %>
 </p>
</body>
</html>