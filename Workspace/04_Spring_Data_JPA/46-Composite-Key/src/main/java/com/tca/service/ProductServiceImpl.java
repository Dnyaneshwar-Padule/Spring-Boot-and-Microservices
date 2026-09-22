package com.tca.service;

import com.tca.entity.Product;
import com.tca.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
}
