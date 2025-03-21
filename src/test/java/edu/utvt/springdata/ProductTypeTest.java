package edu.utvt.springdata;

import edu.utvt.springdata.examen.Entidades.Product;
import edu.utvt.springdata.examen.Entidades.ProductType;
import edu.utvt.springdata.examen.Entidades.Repository.ProductTypeRepository;
import edu.utvt.springdata.examen.Entidades.common.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductTypeTest {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Test
    void addProductType() {
   ProductType productType = new ProductType(null,"Frutas","Con vitamina c", Type.CONSUMER_GOODS, new ArrayList<>());
   this.productTypeRepository.save(productType);
    }

    @Test
    void deleteProductType() {
        ProductType productType = this.productTypeRepository.findAll().getFirst();
        if (productType != null) {
            this.productTypeRepository.delete(productType);
        }
    }

}
