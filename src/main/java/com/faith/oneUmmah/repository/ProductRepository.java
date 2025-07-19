package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAllProducts();

    Optional<Product> findById(Long productId);
}
