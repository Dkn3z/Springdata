package edu.utvt.springdata.examen.Entidades.Controller;

import edu.utvt.springdata.examen.Entidades.Product;

import edu.utvt.springdata.examen.Entidades.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    return ResponseEntity.of(productRepository.findById(id));
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        this.productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
   }

   @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
   }

   @GetMapping("/name/price")
   public ResponseEntity<Product> getProductByNameAndPrice(@PathVariable Long id) {
       return ResponseEntity.of(productRepository.findById(id));
   }

}
