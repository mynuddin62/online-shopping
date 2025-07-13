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

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl(new DummyProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<ProductDTO> allProducts = productService.findAllProductSortedByName();

        req.setAttribute("products", allProducts);
        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req,res);
    }
}
