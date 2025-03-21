package edu.utvt.springdata.examen.Entidades.Repository;

import edu.utvt.springdata.examen.Entidades.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}