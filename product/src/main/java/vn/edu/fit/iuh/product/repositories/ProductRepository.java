package vn.edu.fit.iuh.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fit.iuh.product.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
