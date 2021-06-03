package br.com.learning.customermaintainer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.learning.customermaintainer.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
