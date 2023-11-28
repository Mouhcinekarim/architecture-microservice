package org.sid.Orderservice;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.sid.Orderservice.Entity.Order;
import org.sid.Orderservice.Entity.ProductItem;
import org.sid.Orderservice.Enums.OrderStatus;
import org.sid.Orderservice.Model.Customer;
import org.sid.Orderservice.Model.Product;
import org.sid.Orderservice.Service.CustomerRestClientService;
import org.sid.Orderservice.Service.InventoryRestClientService;
import org.sid.Orderservice.repository.OrderRepository;
import org.sid.Orderservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			InventoryRestClientService inventoryRestClientService
			,CustomerRestClientService customerRestClientService
			) {
		return args -> {
			List<Customer> customers=customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products= inventoryRestClientService.allProducts().getContent().stream().toList();
			Long customerId=1L;
			Random random=new Random();
			Customer customer=customerRestClientService.customerById(customerId);
		    int i=0;
		    while(i++<20) {
		    	Order order=Order.builder()
		    			.customerId(customers.get(random.nextInt(customers.size())).getId())
		    			.orderStatus(Math.random()>0.5?OrderStatus.PENDING: OrderStatus.CREATED)
		    			.createdAt(new java.util.Date())
		    			.build();
		    	Order savedOrder= orderRepository.save(order);
		    	int j=-1;
		    	while(++j<products.size()) {
		    		if(Math.random()>0.70) {
		    			ProductItem productItem =ProductItem.builder()
		    					.order(savedOrder)
			    				.productId(products.get(j).getId())
			    				.price(products.get(j).getPrice())
			    				.quantity(1+random.nextInt(10))
			    				.discount(Math.random())
			    				.build();
		    			productItemRepository.save(productItem);
		    		}
		    	}
		    	
		    }
		};
	}

	
	
	
	
	
	
	
	
	
	
}
