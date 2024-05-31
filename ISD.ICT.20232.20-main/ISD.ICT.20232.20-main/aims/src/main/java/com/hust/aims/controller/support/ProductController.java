package com.hust.aims.controller.support;

import com.hust.aims.entities.product.Product;
import com.hust.aims.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public boolean isSufficientQuantity(Product product, int quantity) {
        return product.getAvailable() >= quantity;
    }
}
