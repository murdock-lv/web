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

            <c:if test="${not empty country}">
                <a href="/adr/${country.name}/"> ${country.name} </a>
                <b>/</b>
            </c:if>

            <c:if test="${not empty county}">
                <a href="/adr/${county.name}/"> ${county.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty parish}">
                <a href="/adr/${parish.formattedAdr}/"> ${parish.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty city}">
                <a href="/adr/${city.formattedAdr}/"> ${city.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty village}">
                <a href="/adr/${village.formattedAdr}/"> ${village.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty street}">
                <a href="/adr/${street.formattedAdr}/"> ${street.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty building}">
                <a href="/adr/${building.formattedAdr}/"> ${building.name} </a>
                <b>/</b>
            </c:if>
            <c:if test="${not empty flat}">
                <a href="/adr/${flat.formattedAdr}/"> ${flat.name}</a>
                <b>/</b>
            </c:if>

        </div>
    </section>

    <section class="section">
        <div class="container">

            <c:if test="${not empty found_building}">
                Found flats :

                <c:forEach items="${building.flats}" var="flat">
                    <li><a href="/adr/${flat.flat.formattedAdr}/">${flat.flat.name}</a></li>
                </c:forEach>
            </c:if>

            <c:if test="${not empty found_street}">
                Found buildings :
                <c:forEach items="${street.buildings}" var="building">
                    <li><a href="/adr/${building.building.formattedAdr}/">${building.building.name}</a></li>
                </c:forEach>
            </c:if>

            <c:if test="${not empty found_city}">
                Found buildings :
                <c:forEach items="${city.buildings}" var="building">
                    <li><a href="/adr/${building.building.formattedAdr}/">${building.building.name}</a></li>
                </c:forEach>

                Found streets :
                <c:forEach items="${city.streets}" var="street">
                    <li><a href="/adr/${street.street.formattedAdr}/">${street.street.name}</a></li>
                </c:forEach>

            </c:if>

            <c:if test="${not empty found_village}">
                Found buildings :
                <c:forEach items="${village.buildings}" var="building">
                    <li><a href="/adr/${building.building.formattedAdr}/">${building.building.name}</a></li>
                </c:forEach>

                Found streets :
                <c:forEach items="${village.streets}" var="street">
                    <li><a href="/adr/${street.street.formattedAdr}/">${street.street.name}</a></li>
                </c:forEach>

            </c:if>

            <c:if test="${not empty found_parish}">
                Found buildings :
                <c:forEach items="${parish.buildings}" var="building">
                    <li><a href="/adr/${building.building.formattedAdr}/">${building.building.name}</a></li>
                </c:forEach>

                Found villages :
                <c:forEach items="${parish.villages}" var="village">
                    <li><a href="/adr/${village.village.formattedAdr}/">${village.village.name}</a></li>
                </c:forEach>
            </c:if>


            <c:if test="${not empty found_county}">
                Found buildings :
                <c:forEach items="${county.buildings}" var="building">
                    <li><a href="/adr/${building.building.formattedAdr}/">${building.building.name}</a></li>
                </c:forEach>

                Found villages :
                <c:forEach items="${county.villages}" var="village">
                    <li><a href="/adr/${village.village.formattedAdr}/">${village.village.name}</a></li>
                </c:forEach>

                Found citys :
                <c:forEach items="${county.citys}" var="city">
                    <li><a href="/adr/${city.city.formattedAdr}/">${city.city.name}</a></li>
                </c:forEach>

                Found parishs :
                <c:forEach items="${county.parishs}" var="parish">
                    <li><a href="/adr/${parish.parish.formattedAdr}/">${parish.parish.name}</a></li>
                </c:forEach>
            </c:if>


            <c:if test="${not empty found_country}">
                Found countys :
                <c:forEach items="${country.countys}" var="county">
                    <li><a href="/adr/${county.name}/">${county.name}</a></li>
                </c:forEach>

                Found citys :
                <c:forEach items="${country.citys}" var="city">
                    <li><a href="/adr/${city.name}/">${city.name}</a></li>
                </c:forEach>
            </c:if>

        </div>
    </section>
</body>
</html>