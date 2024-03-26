package vn.edu.fit.iuh.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fit.iuh.product.models.Product;
import vn.edu.fit.iuh.product.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ap1/v2")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products=productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
