package br.com.learning.customermaintainer.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.learning.customermaintainer.domain.Customer;
import br.com.learning.customermaintainer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {

		List<Customer> customers = service.findAll();

		return ResponseEntity.ok(customers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById( @PathVariable String id ) {

		Customer customer = service.findById(id);

		return ResponseEntity.ok(customer);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Customer customer) {

		service.insert(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
