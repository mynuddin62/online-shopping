<%@include file="includes/header.jsp"  %>
<%@include file="includes/navigation.jsp"  %>


<div class="container my-5">
    <div class="card shadow">
        <div class="card-body">
            <h4 class="card-title mb-4">My Cart</h4>

            <div class="table-responsive">
                <table class="table align-middle">
                    <thead class="table-light">
                    <tr>
                        <th class="w-50" scope="col">Name - Description</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${cart.cartItems}">
                        <tr>
                            <td>${item.product.name} - ${item.product.description}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="item fluctuation button">
                                    <a class="btn btn-outline-secondary">-</a>
                                    <button type="button" class="btn">
                                        <c:out value="${item.quantity}"/>
                                    </button>
                                    <a class="btn btn-outline-secondary">+</a>
                                </div>
                            </td>
                            <td>&#x09F3;${item.price}</td>
                            <td>
                                <button class="btn btn-outline-danger btn-sm">Remove</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                    <!-- Subtotal and Buttons Footer -->
                    <tfoot>
                    <tr>
                        <td colspan="2">
                            <h5 class="mb-0">
                                Subtotal (${cart.totalItem} Items):
                                <span class="text-success">&#x09F3;${cart.totalPrice}</span>
                            </h5>
                        </td>
                        <td colspan="2" class="text-end">
                            <a href="<c:url value='/products'/>" class="btn btn-secondary me-2">Continue Shopping</a>
                            <a href="<c:url value='/checkout'/>" class="btn btn-success">Proceed to Checkout</a>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>

        </div>
    </div>
</div>


<script>
    function updateQuantity(productId, change) {
        // Use fetch or form submission to update quantity
        // Example: send POST to /cart/update?productId=...&delta=...
    }

    function removeItem(productId) {
        // Use fetch or form submission to remove item
        // Example: send POST to /cart/remove?productId=...
    }
</script>



<%@include file="includes/footer.jsp"  %>