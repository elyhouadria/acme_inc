package com.ely.interfaces;

import javax.ejb.Remote;

import com.ely.entities.OrderLine;

@Remote

public interface ACMEOrderLineServicesRemote {

	int AddOrderLine(OrderLine orderLine);
	void DeleteUser(int orderLineId);
	void updateOrderLine(OrderLine orderline);

}
