package com.faith.oneUmmah.web;

import com.faith.oneUmmah.domain.Cart;
import com.faith.oneUmmah.domain.User;
import com.faith.oneUmmah.dto.ProductDTO;
import com.faith.oneUmmah.repository.CartItemRepositoryImpl;
import com.faith.oneUmmah.repository.CartRepositoryImpl;
import com.faith.oneUmmah.repository.ProductRepositoryImpl;
import com.faith.oneUmmah.service.CartService;
import com.faith.oneUmmah.service.CartServiceImpl;
import com.faith.oneUmmah.service.ProductService;
import com.faith.oneUmmah.service.ProductServiceImpl;
import com.faith.oneUmmah.util.SecurityContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServlet.class);

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    private final CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new ProductRepositoryImpl(), new CartItemRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOGGER.info("Serving Home Page");

        List<ProductDTO> allProducts = productService.findAllProductSortedByName();
        LOGGER.info("Total Product Found {}", allProducts.size());

        if(SecurityContext.isAuthenticated(req)) {
            User currentUser = SecurityContext.getCurrentUser(req);
            Cart cart = cartService.getCartByUser(currentUser);
            req.setAttribute("cart", cart);
        }

        req.setAttribute("products", allProducts);
        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req,res);
    }
}
