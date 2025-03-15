package edu.utvt.springdata.data.repositories;

import edu.utvt.springdata.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
