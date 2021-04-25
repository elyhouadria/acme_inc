package com.ely.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.ely.entities.OrderLine;
import com.ely.entities.UserOrder;

@Remote

public interface ACMEUserOrderServicesRemote {

	int addUserOrder(UserOrder userOrder);

	List<UserOrder> getAllUserOrders();

	void deleteUserOrder(int userOrderId);

	void updateUserOrder(UserOrder userorder);
	
	public List<OrderLine> getUserOrderOrderlines(int userOrderId);

}
