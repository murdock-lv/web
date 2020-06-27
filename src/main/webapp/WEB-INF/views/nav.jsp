<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
   <head>
      <title>Navigation</title>
   </head>
   <body>

       <p>County</p>
       <ul>
           <c:forEach items="${addressCountyList}" var="address">
               <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
           </c:forEach>
       </ul>

       <p>Parish</p>
       <ul>
             <c:forEach items="${addressParishList}" var="address">
                 <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
             </c:forEach>
       </ul>


        <p>City</p>
        <ul>
            <c:forEach items="${addressCityList}" var="address">
                <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
            </c:forEach>
        </ul>
        <p>Village</p>
        <ul>
            <c:forEach items="${addressVillageList}" var="address">
                <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
            </c:forEach>
        </ul>

         <p>Street</p>
         <ul>
             <c:forEach items="${addressStreetList}" var="address">
                 <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
             </c:forEach>
         </ul>

         <p>Building</p>
         <ul>
             <c:forEach items="${addressBuildingList}" var="address">
                 <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
             </c:forEach>
         </ul>

          <p>Flat</p>
          <ul>
              <c:forEach items="${addressFlatList}" var="address">
                  <li><a href="/nav/id-${address.id}">${address.formattedAdr}</a></li>
              </c:forEach>
          </ul>

   </body>
</html>