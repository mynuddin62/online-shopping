<%@include file="includes/header.jsp"  %>
<%@include file="includes/navigation.jsp"  %>

<div class="container mt-5">

    <div class="jumbotron text-center py-5">
        <div class="container">
            <div class="row align-items-center">
                <!-- Left Column -->
                <div class="${(cart != null and cart.cartItems.size() > 0) ? 'col-md-6' : 'col-12'}">
                    <h1 class="display-4">
                        <c:if test="${oum:isAuthenticated(pageContext.request)}">
                            Hello <c:out value="${oum:getCurrentUser(pageContext.request).firstName}" />,
                        </c:if>
                        Welcome to e-Shoppers!
                    </h1>
                    <img src="<c:url value='/image/trolly-logo.png'/>"
                         class="img-fluid"
                         style="max-height: 200px; max-width: 200px"
                         alt="Logo">
                </div>

                <!-- Right Column: Show only when cart is not empty -->
                <c:if test="${cart != null and cart.cartItems.size() > 0}">
                    <div class="col-md-6 mb-4">
                        <div class="card text-start shadow-sm">
                            <div class="card-header bg-primary text-white">
                                My Cart
                            </div>
                            <div class="card-body">
                                <p>
                                    Total Items:
                                    <span class="badge rounded-pill bg-success">
                                    <c:out value="${cart.totalItem}" />
                                </span>
                                </p>
                                <p>
                                    Total Price:
                                    <span class="fw-bold">
                                    <c:out value="${cart.totalPrice}" />
                                    <b>&#x09F3;</b>
                                </span>
                                </p>
                                <p>
                                    <a href="#" class="btn btn-success">
                                        Checkout
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
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
                        <a href="#" class="btn btn-outline-info w-100" onclick="addToCart(${product.id})">
                            Add to Cart
                        </a>
                    </div>
                    <script>
                        function addToCart(productId) {
                            document.getElementById("addToCart_"+productId).submit();
                        }
                    </script>
                    <form id="addToCart_${product.id}"
                          style="visibility: hidden;"
                          method="post"
                          action="<c:url value='/add-to-cart?productId=${product.id}'/>">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>


</div>

<%@include file="includes/footer.jsp"  %>