package org.sid.Orderservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.sid.Orderservice.Model.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private Long productId;
	@Transient
	private Product product;
	private double price;
	private int quantity;
	private double discount;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Order order;
	

}
