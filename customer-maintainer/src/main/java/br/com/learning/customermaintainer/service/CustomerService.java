package br.com.learning.customermaintainer.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.learning.customermaintainer.domain.Customer;
import br.com.learning.customermaintainer.dto.CustomerDTO;
import br.com.learning.customermaintainer.repositories.CustomerRepository;
import br.com.learning.customermaintainer.resources.exception.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public void insert(Customer customer) {
		customer.setRecordDate(LocalDate.now());
		repository.insert(customer);
	}

	public List<Customer> findAll() {

		return repository.findAll();
	}

	public Customer findById(String id) throws ObjectNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException( String.format("Customer not found with id: %s", id) ) );
	}

	public void update(String id, CustomerDTO dto) throws ObjectNotFoundException {
		Customer customer = this.findById(id);
		customer.setDocument(dto.getDocument());
		customer.setName(dto.getName());
		repository.save(customer);
	}
	
	public void delete(String id) throws ObjectNotFoundException {
		Customer customer = this.findById(id);
		repository.delete(customer);
	}

}
