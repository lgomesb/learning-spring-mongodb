package br.com.learning.customermaintainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.learning.customermaintainer.domain.Customer;
import br.com.learning.customermaintainer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public void insert(Customer customer) {

		repository.insert(customer);
	}

	public List<Customer> findAll() {

		return repository.findAll();
	}

	public Customer findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("%s Customer Not Found", id)));
	}

}
