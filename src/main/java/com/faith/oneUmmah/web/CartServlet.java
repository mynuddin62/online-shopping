package com.faith.oneUmmah.web;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.repository.CartItemRepositoryImpl;
import com.faith.oneUmmah.repository.CartRepositoryImpl;
import com.faith.oneUmmah.repository.ProductRepositoryImpl;
import com.faith.oneUmmah.service.CartService;
import com.faith.oneUmmah.service.CartServiceImpl;
import com.faith.oneUmmah.util.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartServlet.class);

    private final CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new ProductRepositoryImpl(), new CartItemRepositoryImpl());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var productId = req.getParameter("productId");
        LOGGER.info("Received request to add product with id: {} to cart", productId);

        Cart cart = getCart(req);
        cartService.addProductToCart(productId, cart);

        res.sendRedirect("/home");

    }

    private Cart getCart(HttpServletRequest req) {
        return cartService.getCartByUser(SecurityContext.getCurrentUser(req));
    }
}
