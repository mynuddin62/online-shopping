<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eShoppers</title>

    <!-- Bootstrap CSS via WebJars using c:url -->
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/dist/css/bootstrap.min.css' />" />

    <!-- Bootstrap JS Bundle via WebJars using c:url -->
    <script src="<c:url value='/webjars/bootstrap/5.3.3/dist/js/bootstrap.bundle.min.js' />"></script>
</head>
<body style="padding-top: 25px;">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value='/'/>">e-Shoppers</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value='/'/>">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="jumbotron text-center py-5">
        <h1 class="display-4">Welcome to e-Shoppers!</h1>
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
                            Price: <c:out value="${product.price}" /><b>৳</b>
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

<footer class="footer bg-light text-center text-muted py-3 mt-4">
    <div class="container">
        &copy; eShoppers 2025
    </div>
</footer>

</body>
</html>
