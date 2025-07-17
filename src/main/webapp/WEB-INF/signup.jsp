<%@include file="includes/header.jsp"  %>
<%@include file="includes/navigation.jsp"  %>

<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h3 class="card-title text-center mb-4">Sign Up</h3>

                    <form action="<c:url value='/signup' />" method="post" class="row g-3 needs-validation" novalidate>

                        <!-- Username -->
                        <div class="col-md-12">
                            <label for="username" class="form-label">Username</label>
                            <input class="form-control" id="username" name="username" value="${userDTO.username}" minlength="4" maxlength="32" required aria-describedby="usernameHelp" />
                            <div id="usernameHelp" class="form-text">minimum 4 characters and maximum 32 characters</div>
                            <div class="valid-feedback">Looks good!</div>
                            <div class="invalid-feedback">Please choose a valid username.</div>
                            <c:if test="${errors.username != null}">
                                <small class="text-danger"> ${errors.username}</small>
                            </c:if>
                        </div>

                        <!-- Email -->
                        <div class="col-md-12">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="${userDTO.email}" required aria-describedby="emailHelp" placeholder="you@example.com" />
                            <div id="emailHelp" class="form-text">We'll never share your email.</div>
                            <div class="valid-feedback">Looks good!</div>
                            <div class="invalid-feedback">Please provide a valid email address.</div>
                            <c:if test="${errors.email != null}">
                                <small class="text-danger"> ${errors.email}</small>
                            </c:if>
                        </div>

                        <!-- Password -->
                        <div class="col-md-12">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" minlength="4" maxlength="32" required aria-describedby="passwordHelp" />
                            <div id="passwordHelp" class="form-text">minimum 4 characters and maximum 32 characters</div>
                            <div class="valid-feedback">Looks good!</div>
                            <div class="invalid-feedback">minimum 4 characters and maximum 32 characters</div>
                            <c:if test="${errors.password != null}">
                                <small class="text-danger"> ${errors.password}</small>
                            </c:if>
                        </div>

                        <!-- Confirm Password -->
                        <div class="col-md-12">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required aria-describedby="confirmHelp" />
                            <div id="confirmHelp" class="form-text">Must match the password</div>
                            <div class="valid-feedback">Passwords match!</div>
                            <div class="invalid-feedback">Passwords do not match.</div>
                            <c:if test="${errors.confirmPassword != null}">
                                <small class="text-danger"> ${errors.confirmPassword}</small>
                            </c:if>
                        </div>

                        <!-- First Name -->
                        <div class="col-md-6">
                            <label for="firstName" class="form-label">First Name</label>
                            <input class="form-control" id="firstName" name="firstName" value="${userDTO.firstName}" minlength="4" maxlength="32" required />
                            <div class="valid-feedback">Looks good!</div>
                            <div class="invalid-feedback">minimum 1 character and maximum 32 characters</div>
                            <c:if test="${errors.firstName != null}">
                                <small class="text-danger"> ${errors.firstName}</small>
                            </c:if>
                        </div>

                        <!-- Last Name -->
                        <div class="col-md-6">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input class="form-control" id="lastName" name="lastName" value="${userDTO.lastName}" minlength="4" maxlength="32" required />
                            <div class="valid-feedback">Looks good!</div>
                            <div class="invalid-feedback">minimum 1 character and maximum 32 characters</div>
                            <c:if test="${errors.lastName != null}">
                                <small class="text-danger"> ${errors.lastName}</small>
                            </c:if>
                        </div>

                        <!-- Submit Button -->
                        <div class="col-12 d-grid mt-3">
                            <button type="submit" class="btn btn-primary" aria-label="Submit Signup Form">Signup</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        'use strict';

        const forms = document.querySelectorAll('.needs-validation');
        const password = document.getElementById("password");
        const confirmPassword = document.getElementById("confirmPassword");

        // Password match validation
        function validatePasswordMatch() {
            if (confirmPassword.value === "") {
                confirmPassword.classList.remove("is-valid", "is-invalid");
                return;
            }

            if (password.value === confirmPassword.value) {
                confirmPassword.classList.add("is-valid");
                confirmPassword.classList.remove("is-invalid");
            } else {
                confirmPassword.classList.add("is-invalid");
                confirmPassword.classList.remove("is-valid");
            }
        }

        // Live validation on password fields
        password.addEventListener("input", validatePasswordMatch);
        confirmPassword.addEventListener("input", validatePasswordMatch);

        // Custom Bootstrap validation
        forms.forEach(function (form) {
            form.addEventListener("submit", function (event) {

                // Prevent if form invalid
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }

                // Extra check: password match
                if (password.value !== confirmPassword.value) {
                    event.preventDefault();
                    confirmPassword.classList.add("is-invalid");
                    confirmPassword.classList.remove("is-valid");
                }

                form.classList.add("was-validated");
            });
        });
    });
</script>


<%@include file="includes/footer.jsp"  %>