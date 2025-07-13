package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public class DummyProductRepositoryImpl implements ProductRepository {

    @Override
    public List<ProductDTO> findAllProducts() {
        return List.of(
                new ProductDTO(
                        "Honor 5",
                        "Smart Watch",
                        BigDecimal.valueOf(3499)),
                new ProductDTO(
                        "PNY Pendrive",
                        "64GB",
                        BigDecimal.valueOf(1999))
        );
    }
}
