package org.sid.Orderservice.repository;

import java.util.List;

import org.sid.Orderservice.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import feign.Param;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long>{

	@RestResource(path="/byCustomerId")
	List<Order> findByCustomerId(@Param("customerId") Long customerId);
}




