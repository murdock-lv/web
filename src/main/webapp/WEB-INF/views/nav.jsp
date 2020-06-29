<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
      <title>Navigation</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    </head>
    <body>

        <section class="section">
            <div class="container">

               <a href="/nav/id-100000000">LV </a>
               <c:forEach items="${addressPath}" var="address">

                   <c:if test="${address.level == 'PARISH'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.parish}</a>
                   </c:if>
                   <c:if test="${address.level == 'COUNTY'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.county}</a>
                   </c:if>
                   <c:if test="${address.level == 'CITY'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.city}</a>
                   </c:if>
                   <c:if test="${address.level == 'VILLAGE'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.village}</a>
                   </c:if>
                   <c:if test="${address.level == 'STREET'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.street}</a>
                   </c:if>
                   <c:if test="${address.level == 'BUILDING'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.building} </a>
                   </c:if>
                   <c:if test="${address.level == 'FLAT'}">
                        ->
                        <a href="/nav/id-${address.id}">${address.flat} </a>
                   </c:if>

                </c:forEach>

            </div>
        </section>

        <section class="section">
            <div class="container">

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

            </div>
        </section>
    </body>
</html>