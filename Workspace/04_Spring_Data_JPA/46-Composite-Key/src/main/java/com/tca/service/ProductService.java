package com.tca.service;

import com.tca.entity.Product;

import java.util.Optional;

public interface ProductService {

    Product save(Product p);

    Optional<Product> getById(Long id);
}
