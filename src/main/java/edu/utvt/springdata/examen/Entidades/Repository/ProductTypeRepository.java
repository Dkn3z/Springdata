package edu.utvt.springdata.examen.Entidades.Repository;

import edu.utvt.springdata.examen.Entidades.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}