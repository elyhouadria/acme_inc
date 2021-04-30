package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.OrderLine;
import com.ely.entities.Product;
import com.ely.entities.UserOrder;

@Remote

public interface ACMEOrderLineServicesRemote {

	int addOrderLine(OrderLine orderLine);
	void deleteOrderLine(int orderLineId);
	void updateOrderLine(OrderLine orderline);
	public List<OrderLine> getAllOrderLines();
	public UserOrder findUserOrderById(int userOrderId);
	public Product findProductById(int productId);
}
