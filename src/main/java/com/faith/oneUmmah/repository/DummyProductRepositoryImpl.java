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
                        BigDecimal.valueOf(1999)),
                new ProductDTO(
                        "Samsung Galaxy S24 Ultra",
                        "Flagship Smartphone",
                        BigDecimal.valueOf(149999)),
                new ProductDTO(
                        "Apple MacBook Air M3",
                        "Ultra-thin Laptop",
                        BigDecimal.valueOf(125000)),
                new ProductDTO(
                        "Sony WH-1000XM5",
                        "Noise-Cancelling Headphones",
                        BigDecimal.valueOf(38000)),
                new ProductDTO(
                        "Logitech MX Master 3S",
                        "Advanced Wireless Mouse",
                        BigDecimal.valueOf(12000)),
                new ProductDTO(
                        "Amazon Kindle Paperwhite",
                        "E-reader with Backlight",
                        BigDecimal.valueOf(18000)),
                new ProductDTO(
                        "Nintendo Switch OLED",
                        "Hybrid Gaming Console",
                        BigDecimal.valueOf(45000)),
                new ProductDTO(
                        "Xiaomi Smart Band 8 Pro",
                        "Fitness Tracker with AMOLED Display",
                        BigDecimal.valueOf(7000)),
                new ProductDTO(
                        "WD Elements Portable",
                        "2TB External Hard Drive",
                        BigDecimal.valueOf(9500)),
                new ProductDTO(
                        "Anker PowerCore III Elite",
                        "20000mAh Power Bank",
                        BigDecimal.valueOf(8000)),
                new ProductDTO(
                        "Bose SoundLink Revolve+",
                        "Portable Bluetooth Speaker",
                        BigDecimal.valueOf(30000)),
                new ProductDTO(
                        "Philips Hue White & Color Ambiance",
                        "Smart Light Bulb Starter Kit",
                        BigDecimal.valueOf(15000)),
                new ProductDTO(
                        "Dyson V15 Detect Absolute",
                        "Cordless Vacuum Cleaner",
                        BigDecimal.valueOf(85000)),
                new ProductDTO(
                        "GoPro HERO12 Black",
                        "Waterproof Action Camera",
                        BigDecimal.valueOf(42000)),
                new ProductDTO(
                        "LG C3 OLED TV",
                        "55-inch 4K Smart TV",
                        BigDecimal.valueOf(180000))
        );
    }

}
