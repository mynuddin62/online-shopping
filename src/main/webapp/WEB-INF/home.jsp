<%@include file="includes/header.jsp"  %>
<%@include file="includes/navigation.jsp"  %>

<div class="container mt-5">
    <div class="jumbotron text-center py-5">
        <h1 class="display-4">
            <c:if test="${sessionScope.user != null}">
                Hello <c:out value="${sessionScope.user.firstName}" />,
            </c:if>
            Welcome to e-Shoppers!
        </h1>
        <img src="<c:url value='/image/trolly-logo.png'/>" class="img-fluid" style="max-height: 200px; max-width: 200px" alt="Logo">
    </div>

    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-4">
        <c:forEach var="product" items="${products}">
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:out value="${product.name}" />
                        </h5>
                        <p class="card-text">
                            <c:out value="${product.description}" />
                        </p>
                        <p class="card-text fw-bold">
                            Price: <c:out value="${product.price}" />
                            <b>&#x09F3;</b>
                        </p>
                    </div>
                    <div class="card-footer bg-transparent border-top-0">
                        <a href="#" class="btn btn-outline-info w-100">
                            Add to Cart
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>

<%@include file="includes/footer.jsp"  %>