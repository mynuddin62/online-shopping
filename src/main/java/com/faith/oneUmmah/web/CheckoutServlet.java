package com.faith.oneUmmah.web;

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

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutServlet.class);

    private final CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new ProductRepositoryImpl(), new CartItemRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOGGER.info("Serving checkout page");
        var cart = cartService.getCartByUser(SecurityContext.getCurrentUser(req));
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req,res);
    }
}
