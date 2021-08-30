package br.com.learning.customermaintainer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.learning.customermaintainer.domain.Customer;
import br.com.learning.customermaintainer.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerMaintainerApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerMaintainerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		List<Customer> customers = Arrays.asList(
				new Customer(null, "Fulando de Tal", "12324345657", LocalDate.now()),
				new Customer(null, "Cicrano da Silva", "76652545436", LocalDate.now()),
				new Customer(null, "João da Silva", "99888745436", LocalDate.now())
				);
		
		repository.saveAll(customers);
	}

}
