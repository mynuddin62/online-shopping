package com.faith.oneUmmah.web;

import com.faith.oneUmmah.dto.ProductDTO;
import com.faith.oneUmmah.repository.DummyProductRepositoryImpl;
import com.faith.oneUmmah.service.ProductService;
import com.faith.oneUmmah.service.ProductServiceImpl;
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

    private final ProductService productService = new ProductServiceImpl(new DummyProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOGGER.info("Serving Home Page");

        List<ProductDTO> allProducts = productService.findAllProductSortedByName();
        LOGGER.info("Total Product Found {}", allProducts.size());

        /*for(int i = 0; i < 1_000; i++){
            LOGGER.info("dummy log");
        }*/

        req.setAttribute("products", allProducts);
        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req,res);
    }
}
