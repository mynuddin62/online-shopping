<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <!-- Bootstrap 5.3.3 CSS from WebJars -->
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/dist/css/bootstrap.min.css' />" />
</head>
<body class="d-flex flex-column min-vh-100 bg-light text-center">

<div class="container mt-5">
    <h2 class="display-4 text-primary mb-4">e-Shoppers</h2>
    <a href="<c:url value='/home' />" class="btn btn-outline-primary btn-lg">Enter App</a>
</div>

<!-- Bootstrap JS -->
<script src="<c:url value='/webjars/bootstrap/5.3.3/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
