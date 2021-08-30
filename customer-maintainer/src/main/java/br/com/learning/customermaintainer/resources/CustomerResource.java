package br.com.learning.customermaintainer.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.learning.customermaintainer.domain.Customer;
import br.com.learning.customermaintainer.dto.CustomerDTO;
import br.com.learning.customermaintainer.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("http://localhost:4200")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById( @PathVariable String id ) throws Exception {
		Customer customer = service.findById(id);
		return ResponseEntity.ok(customer);
	}
	
	@PostMapping
	public ResponseEntity<Customer> insert(@Validated @RequestBody CustomerDTO dto) {
		Customer customer = new Customer(dto);
		service.insert(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(uri).body(customer);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update( @PathVariable String id, @Validated @RequestBody CustomerDTO dto) throws Exception {		
		service.update(id, dto);
		return ResponseEntity.accepted().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable String id ) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
