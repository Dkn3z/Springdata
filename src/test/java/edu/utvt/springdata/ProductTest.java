package edu.utvt.springdata;

import edu.utvt.springdata.examen.Entidades.Product;
import edu.utvt.springdata.examen.Entidades.ProductType;
import edu.utvt.springdata.examen.Entidades.Repository.ProductRepository;

import edu.utvt.springdata.examen.Entidades.Repository.ProductTypeRepository;
import edu.utvt.springdata.examen.Entidades.common.Type;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Test
    @Transactional
    @Rollback(false)
    void addProduct() {
     ProductType productType = null;
     productType = this.productTypeRepository.findAll().getFirst();
     Product product = new Product(null,"Frutas",15.0,productType);
     this.productRepository.save(product);
        }

 /*       @Test
    void findByNameAndPrice(){
        Pageable pageable = PageRequest.of(0,5);
            Page<Product>page = this.productRepository.findByNameAndPrice("Frutas",15.0);
            System.out.println(page.getTotalElements());
            System.out.println(page.getTotalPages());
        }*/

    @Test
    void deleteProduct() {
        Product product = this.productRepository.findAll().getFirst();
        if (product != null) {
            this.productRepository.delete(product);
        }
    }
}
