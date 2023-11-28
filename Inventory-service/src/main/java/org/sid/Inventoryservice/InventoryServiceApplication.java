package org.sid.Inventoryservice;

import java.util.List;
import java.util.Random;

import org.sid.Inventoryservice.Entity.Product;
import org.sid.Inventoryservice.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//peut le faire par default
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
	return args -> {
		int i=0;
		Random random =new Random();
		while(i++<10)
		productRepository.saveAll(
				List.of(
						Product.builder()
						.name("Computer "+i)
						.price(1200+Math.random()*1000)
						.quantity(random.nextInt(200)+1)
						.build()
					 
						)
				);
		
	};
	}

}
