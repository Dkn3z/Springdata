package edu.utvt.springdata;

import edu.utvt.springdata.data.common.ReatingOptions;
import edu.utvt.springdata.data.entities.Address;
import edu.utvt.springdata.data.entities.Author;
import edu.utvt.springdata.data.entities.Book;
import edu.utvt.springdata.data.entities.Rating;
import edu.utvt.springdata.data.repositories.AddressRepository;
import edu.utvt.springdata.data.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneTest {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Test
    void addAddress() {
        Author author = null;
        if (this.authorRepository.count() > 0) {
            author = this.authorRepository.findAll().getFirst();
            Address address = new Address(null, "Miguel hidalgo","Mexico",author);
            this.addressRepository.save(address);
            }}

    @Test
    void deleteAddress() {
        Address address = this.addressRepository.findAll().getFirst();
        if (address != null) {
            this.addressRepository.delete(address);
        }
    }
    }


