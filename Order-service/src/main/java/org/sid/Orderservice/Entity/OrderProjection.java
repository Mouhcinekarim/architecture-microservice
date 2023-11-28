package org.sid.Orderservice.Entity;

import java.util.Date;

import org.sid.Orderservice.Enums.OrderStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullOrder",types= Order.class)
public interface OrderProjection {

	Long getId();
	Date getCreatedAt();
	Long getCustomerId();
	OrderStatus getOrderStatus();
}
