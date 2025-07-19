package com.faith.oneUmmah.repository;

import com.faith.oneUmmah.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private static final List<Product> ALL_PRODUCTS = List.of(
            new Product(
                    1L,
                    "Honor 5",
                    "Smart Watch",
                    BigDecimal.valueOf(3499)),
            new Product(
                    2L,
                    "PNY Pendrive",
                    "64GB",
                    BigDecimal.valueOf(1999)),
            new Product(
                    3L,
                    "Samsung Galaxy S24 Ultra",
                    "Flagship Smartphone",
                    BigDecimal.valueOf(149999)),
            new Product(
                    4L,
                    "Apple MacBook Air M3",
                    "Ultra-thin Laptop",
                    BigDecimal.valueOf(125000)),
            new Product(
                    5L,
                    "Sony WH-1000XM5",
                    "Noise-Cancelling Headphones",
                    BigDecimal.valueOf(38000)),
            new Product(
                    6L,
                    "Logitech MX Master 3S",
                    "Advanced Wireless Mouse",
                    BigDecimal.valueOf(12000)),
            new Product(
                    7L,
                    "Amazon Kindle Paperwhite",
                    "E-reader with Backlight",
                    BigDecimal.valueOf(18000)),
            new Product(
                    8L,
                    "Nintendo Switch OLED",
                    "Hybrid Gaming Console",
                    BigDecimal.valueOf(45000)),
            new Product(
                    9L,
                    "Xiaomi Smart Band 8 Pro",
                    "Fitness Tracker with AMOLED Display",
                    BigDecimal.valueOf(7000)),
            new Product(
                    10L,
                    "WD Elements Portable",
                    "2TB External Hard Drive",
                    BigDecimal.valueOf(9500)),
            new Product(
                    11L,
                    "Anker PowerCore III Elite",
                    "20000mAh Power Bank",
                    BigDecimal.valueOf(8000)),
            new Product(
                    12L,
                    "Bose SoundLink Revolve+",
                    "Portable Bluetooth Speaker",
                    BigDecimal.valueOf(30000)),
            new Product(
                    13L,
                    "Philips Hue White & Color Ambiance",
                    "Smart Light Bulb Starter Kit",
                    BigDecimal.valueOf(15000)),
            new Product(
                    14L,
                    "Dyson V15 Detect Absolute",
                    "Cordless Vacuum Cleaner",
                    BigDecimal.valueOf(85000)),
            new Product(
                    15L,
                    "GoPro HERO12 Black",
                    "Waterproof Action Camera",
                    BigDecimal.valueOf(42000)),
            new Product(
                    16L,
                    "LG C3 OLED TV",
                    "55-inch 4K Smart TV",
                    BigDecimal.valueOf(180000))
    );

    @Override
    public List<Product> findAllProducts() {
        return ALL_PRODUCTS;
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return findAllProducts().stream().filter(product -> product.getId().equals(productId)).findFirst();
    }

}
