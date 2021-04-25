package com.ely.interfaces;

import javax.ejb.Remote;

import com.ely.entities.OrderLine;

@Remote

public interface ACMEOrderLineServicesRemote {

	int addOrderLine(OrderLine orderLine);
	void deleteOrderLine(int orderLineId);
	void updateOrderLine(OrderLine orderline);

}
