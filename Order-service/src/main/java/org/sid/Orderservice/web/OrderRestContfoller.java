package org.sid.Orderservice.web;

import org.sid.Orderservice.Entity.Order;
import org.sid.Orderservice.Model.Customer;
import org.sid.Orderservice.Model.Product;
import org.sid.Orderservice.Service.CustomerRestClientService;
import org.sid.Orderservice.Service.InventoryRestClientService;
import org.sid.Orderservice.repository.OrderRepository;
import org.sid.Orderservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestContfoller {

	private OrderRepository orderRepository;
	private CustomerRestClientService customerRestClientService;
	private InventoryRestClientService inventoryRestClientService;
	
	public OrderRestContfoller(OrderRepository orderRepository, 
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService) {
		super();
		this.orderRepository = orderRepository;
		this.customerRestClientService = customerRestClientService;
		this.inventoryRestClientService = inventoryRestClientService;
	}

	@GetMapping("/fullOrder/{id}")
	public Order getOrder(@PathVariable Long id) {
		Order order=orderRepository.findById(id).get();
		Customer customer = customerRestClientService.customerById(order.getId());
		order.setCustomer(customer);
		order.getProductItems().forEach((pi)->{
			
			Product product= inventoryRestClientService.productById(pi.getProductId());
			pi.setProduct(product);			
		});
		return order;
	}
}
