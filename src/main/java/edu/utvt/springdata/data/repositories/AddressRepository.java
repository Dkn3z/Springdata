package edu.utvt.springdata.data.repositories;

import edu.utvt.springdata.data.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}