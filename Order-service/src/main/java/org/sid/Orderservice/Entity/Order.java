package org.sid.Orderservice.Entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.sid.Orderservice.Enums.OrderStatus;
import org.sid.Orderservice.Model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "orders")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date createdAt;
	private OrderStatus orderStatus;
	private Long customerId;
	@Transient//pas persister
	private Customer customer;
	@OneToMany(mappedBy = "order")
	private List<ProductItem> productItems;
}
