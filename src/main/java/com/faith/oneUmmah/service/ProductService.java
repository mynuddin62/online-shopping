package com.faith.oneUmmah.service;

import com.faith.oneUmmah.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProductSortedByName();
}
