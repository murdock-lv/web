<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Navigation</title>
   </head>
   <body>
        <ul>
            <c:forEach items="${addressList}" var="address">
                <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
            </c:forEach>
        </ul>
   </body>
</html>