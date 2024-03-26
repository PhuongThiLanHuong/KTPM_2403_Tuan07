package vn.edu.fit.iuh.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.fit.iuh.product.models.Product;
import vn.edu.fit.iuh.product.repositories.ProductRepository;

import java.util.Random;

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
    @Autowired
    private ProductRepository productRepository;

   // @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Random random=new Random();
            for(int i=0;i<5;i++){
                Product product=new Product("product name #"+i, random.nextDouble(100000,2000000));
                productRepository.save(product);
            }
        };
    }
}
