package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllProducts();
}
