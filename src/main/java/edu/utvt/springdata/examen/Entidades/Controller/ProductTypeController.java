package edu.utvt.springdata.examen.Entidades.Controller;

import edu.utvt.springdata.examen.Entidades.ProductType;

import edu.utvt.springdata.examen.Entidades.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/productType")
public class ProductTypeController {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping("/name")
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
