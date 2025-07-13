package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.dto.ProductDTO;

import java.util.List;

public interface ProductRepository {
    List<ProductDTO> findAllProducts();
}
