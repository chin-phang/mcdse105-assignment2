package org.mcdse105.assignment2.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mcdse105.assignment2.entity.Product;
import org.mcdse105.assignment2.exception.DuplicateProductException;
import org.mcdse105.assignment2.exception.InvalidNameProductException;
import org.mcdse105.assignment2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addNewProduct(Product product) {
        if (StringUtils.isBlank(product.getName())) {
            throw new InvalidNameProductException("Product name is blank");
        }

        final Optional<Product> existingProductOpt = productRepository.findProductByName(product.getName());

        if (existingProductOpt.isPresent()) {
            throw new DuplicateProductException("Product " + product.getName() + " is already exists.");
        }

        Product savedProduct = new Product();

        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setQuantity(product.getQuantity());

        return productRepository.save(savedProduct);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Product updateProductDetails(Long id, Product product) {
        Product savedProduct = productRepository.findById(id).orElse(new Product());

        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setQuantity(product.getQuantity());

        return productRepository.save(savedProduct);
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }

    public boolean productExists(String name) {
        return productRepository.findProductByName(name).isPresent();
    }
}
