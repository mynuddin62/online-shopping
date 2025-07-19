package com.faith.oneUmmah.service;

import com.faith.oneUmmah.domain.Product;
import com.faith.oneUmmah.dto.ProductDTO;
import com.faith.oneUmmah.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private static final Product WEB_PROGRAMMING_BOOK
            = new Product(
            1L,
            "Java Web Programming",
            "Book Of A N M Bazlur Rahman",
            BigDecimal.valueOf(480)
    );

    private static final Product HONOR_SMART_WATCH
            =new Product(
            2L,
            "Honor 5",
            "Smart Watch",
            BigDecimal.valueOf(3499));

    private static final Product PNY_PENDRIVE
            = new Product(
            3L,
            "PNY Pendrive",
            "64GB",
            BigDecimal.valueOf(1999));

    private ProductRepository productRepository;
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void shouldReturnProductsSortedByName() {

        List<Product> mockProducts = List.of(WEB_PROGRAMMING_BOOK, HONOR_SMART_WATCH, PNY_PENDRIVE);
        when(productRepository.findAllProducts()).thenReturn(mockProducts);

        // Act
        var sortedProducts = productService.findAllProductSortedByName();


        // Testing for whole list
        // Assert
        assertThat(sortedProducts)
                .extracting(ProductDTO::getName)
                .containsExactly(
                        HONOR_SMART_WATCH.getName(),
                        WEB_PROGRAMMING_BOOK.getName(),
                        PNY_PENDRIVE.getName());

        verify(productRepository, times(1)).findAllProducts();


        /*Assertions.assertEquals(HONOR_SMART_WATCH.getName(), sortedProducts.get(0).getName());
        Assertions.assertEquals(WEB_PROGRAMMING_BOOK.getName(), sortedProducts.get(1).getName());
        Assertions.assertEquals(PNY_PENDRIVE.getName(), sortedProducts.get(2).getName());*/
    }
}
