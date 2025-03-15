package edu.utvt.springdata;

import edu.utvt.springdata.data.entities.Address;
import edu.utvt.springdata.data.entities.Author;
import edu.utvt.springdata.data.entities.Book;
import edu.utvt.springdata.data.repositories.AuthorRepository;
import edu.utvt.springdata.data.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ManyToManyTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void add(){
        Author author = new Author(null,"J. R. R. TALKING", new ArrayList<Book>(),new Address());
        Book book = this.bookRepository.findAll().getFirst();

        if (book != null) {
            author.getBooks().add(book);
            this.authorRepository.save(author);
        }}

    @Test
    void delete(){
        Author author = this.authorRepository.findAll().getFirst();
        if (author != null) {
            this.authorRepository.delete(author);
        }

    }
}
