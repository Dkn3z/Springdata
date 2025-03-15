package edu.utvt.springdata.data.repositories;

import edu.utvt.springdata.data.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
