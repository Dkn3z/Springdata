package edu.utvt.springdata.data.repositories;

import edu.utvt.springdata.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
