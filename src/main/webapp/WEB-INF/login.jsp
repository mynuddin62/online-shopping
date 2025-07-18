<%@include file="includes/header.jsp"  %>
<%@include file="includes/navigation.jsp"  %>

<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body">

                    <!-- Alert Message -->
                    <c:if test="${message != null}">
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                                ${message}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>


                    <h3 class="card-title text-center mb-4">Login</h3>

                    <!-- Login Form -->
                    <form action="<c:url value='/login' />" method="post" class="row g-3">

                        <!-- Username -->
                        <div class="col-md-12">
                            <label for="username" class="form-label">Username</label>
                            <input class="form-control" id="username" name="username" required/>
                            <c:if test="${errors.username != null}">
                                <small class="text-danger">${errors.username}</small>
                            </c:if>
                        </div>

                        <!-- Password -->
                        <div class="col-md-12">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required />
                            <c:if test="${errors.password != null}">
                                <small class="text-danger">${errors.password}</small>
                            </c:if>
                        </div>

                        <!-- Submit Button -->
                        <div class="col-12 d-grid mt-3">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>

                        <!-- Link to Signup -->
                        <div class="col-12 text-center mt-2">
                            <small>Don't have an account? <a class="btn-link" href="<c:url value='/signup' />">Sign up</a></small>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="includes/footer.jsp"  %>