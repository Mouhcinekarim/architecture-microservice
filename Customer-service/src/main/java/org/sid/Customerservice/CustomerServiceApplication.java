package org.sid.Customerservice;

import java.util.List;

import org.sid.Customerservice.Entity.Customer;
import org.sid.Customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().
					name("Mohamed")
					.email("med@gmail.com")
					.build(),
					Customer.builder().
					name("hassan")
					.email("hassan@gmail.com")
					.build(),
					Customer.builder().
					name("imane")
					.email("imane@gmail.com")
					.build()
					));
			
		};
	}

}
